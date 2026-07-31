# Spring Cache 深度解析与实战笔记

---

## 一、 实战 Sample

一个完整的 Spring Cache + Redis 配置与使用示例。

### 1. 依赖配置 (`pom.xml`)

```xml
<dependencies>
    <!-- Spring Cache 抽象层 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-cache</artifactId>
    </dependency>
    <!-- Redis 实现底层 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
</dependencies>
```

### 2. 配置文件 (`application.yml`)

```yaml
spring:
  cache:
    type: redis
    redis:
      time-to-live: 600000ms # 默认过期时间 10分钟
      cache-null-values: true # 是否缓存 null 值（防止缓存穿透）
      use-key-prefix: true
      key-prefix: "APP_CACHE:"
  data:
    redis:
      host: localhost
      port: 6379
```

### 3. Java 配置类 (`CacheConfig.java`)

支持自定义序列化方式（如 JSON 替代 Java 默认序列化）和对不同 Cache 设置独立的 TTL：

```java
package com.example.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching // 开启 Spring Cache 声明式缓存
public class CacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        // 默认配置
        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));

        // 为特定的 CacheName 定制配置
        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        configMap.put("user_cache", defaultConfig.entryTtl(Duration.ofHours(1)));
        configMap.put("city_cache", defaultConfig.entryTtl(Duration.ofDays(1)));

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultConfig)
                .withInitialCacheConfigurations(configMap)
                .build();
    }

    // 自定义 Key 生成器
    @Bean("customKeyGenerator")
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getSimpleName()).append(":");
            sb.append(method.getName()).append(":");
            for (Object obj : params) {
                sb.append(obj.toString()).append(",");
            }
            return sb.toString();
        };
    }
}
```

### 4. 业务逻辑与注解使用 (`UserService.java`)

```java
package com.example.service;

import com.example.entity.User;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "user_cache") // 类级别配置默认 cacheNames
public class UserService {

    /**
     * 查询数据：优先读缓存，若无缓存则执行方法并写入缓存
     */
    @Cacheable(key = "#id", unless = "#result == null")
    public User getUserById(Long id) {
        System.out.println(">>> [DB Query] Executing getUserById for id: " + id);
        return new User(id, "User_" + id);
    }

    /**
     * 更新数据：执行方法，并将返回值更新到缓存中
     */
    @CachePut(key = "#user.id")
    public User updateUser(User user) {
        System.out.println(">>> [DB Update] Executing updateUser for id: " + user.getId());
        return user;
    }

    /**
     * 删除数据：执行方法后删除对应的缓存
     */
    @CacheEvict(key = "#id", beforeInvocation = false)
    public void deleteUser(Long id) {
        System.out.println(">>> [DB Delete] Executing deleteUser for id: " + id);
    }

    /**
     * 自定义 KeyGenerator 使用示例
     */
    @Cacheable(keyGenerator = "customKeyGenerator")
    public User getUserByNameAndAge(String name, Integer age) {
        return new User(1L, name);
    }

    /**
     * 一般函数：无缓存注解
     */
    public int calculateAge(String birthDate) {
        return 25;
    }
}
```

---

## 二、 源码级原理解析与 AutoProxyRegistrar 底层机制

Spring Cache 核心基于 **Spring AOP (Aspect Oriented Programming)** 架构。下面拆解“启动阶段”与“请求处理阶段”的具体类与方法细节。

---

### 阶段 1：Spring 启动阶段发生了什么？

整个过程的目标是 **扫描缓存注解 -> 注册自动代理创建器 -> 解析元数据 -> 构建 AOP 代理 -> 准备 CacheManager**。

```text
@EnableCaching 
  └── Import(CachingConfigurationSelector)
        ├── 1. AutoProxyRegistrar
        │     └── 向容器注册 InfrastructureAdvisorAutoProxyCreator (AOP自动代理创建器)
        └── 2. ProxyCachingConfiguration (Bean定义配置)
              ├── CacheOperationSource (解析注解元数据)
              ├── CacheInterceptor (MethodInterceptor 核心拦截器)
              └── BeanFactoryCacheOperationSourceAdvisor (AOP 切面顾问)
```

#### 1. 底线基础：`AutoProxyRegistrar` 的角色与机制
* **作用**：`AutoProxyRegistrar` 实现了 `ImportBeanDefinitionRegistrar` 接口。它的唯一职责是调用 `AopConfigUtils.registerAutoProxyCreatorIfNecessary(registry)`，向容器注册 **`InfrastructureAdvisorAutoProxyCreator`** 类型的 BeanDefinition。
* **分工**：`AutoProxyRegistrar` 负责搭建 Spring AOP 代理生成的底座（创建代理的工厂），而 `ProxyCachingConfiguration` 负责组装缓存切面（Advisor）。

#### 2. 切面组件注册：
`ProxyCachingConfiguration` 配置类向 BeanFactory 注册了三个关键 Bean：
* **`BeanFactoryCacheOperationSourceAdvisor`**：AOP 切面通知器，包含切点 `CacheOperationSourcePointcut`。
* **`CacheOperationSource`**（实现类 `AnnotationCacheOperationSource`）：负责解析 `@Cacheable` 等注解。
* **`CacheInterceptor`**：核心 AOP 拦截器（实现了 `MethodInterceptor`）。

#### 3. Bean 实例化与代理创建（BeanPostProcessor 阶段）：
* 在容器初始化普通 Bean（如 `UserService`）时，`InfrastructureAdvisorAutoProxyCreator`（由 `AutoProxyRegistrar` 引入）作为 `BeanPostProcessor` 介入。
* 它通过 `AnnotationCacheOperationSource.findCacheOperations(Method/Class)` 检查 Bean 的方法是否有缓存注解。
* 如果找到注解，Spring 会为该 Bean **生成 JDK 动态代理或 CGLIB 子类代理**，并将 `CacheInterceptor` 塞入代理对象的拦截器链。

#### 4. CacheManager 初始化：
* 容器启动时初始化 `CacheManager`（如 `RedisCacheManager`），维护 `ConcurrentHashMap<String, Cache>`。

---

### 阶段 2：Request 经过 `@Cacheable` 方法时发生了什么？

完整的方法调用链图解与核心源码路径：

```text
Caller 
  │
  ▼
Proxy Object
  │
  ▼
CacheInterceptor.invoke()
  │
  ▼
CacheAspectSupport.execute()
  │
  ├── 1. CacheOperationSource.getCacheOperations() [获取缓存元数据]
  │
  ├── 2. Evaluates Context [构建 Evaluator, 解析 SpEL 生成 Key]
  │
  ├── 3. CacheAspectSupport.findCachedItem() [查找缓存]
  │      └── Cache.get(key) / RedisCache.get(key)
  │
  ├── 4. [命中缓存 ?]
  │      ├── YES ──> 返回缓存值 (跳过目标方法调用)
  │      └── NO  ──> 继续执行目标方法
  │                     │
  │                     ▼
  │               invoker.invoke() [执行实际目标方法/数据库查询]
  │                     │
  │                     ▼
  │               CacheAspectSupport.collectPutRequests() [条件评估(unless/condition)]
  │                     │
  │                     ▼
  │               Cache.put(key, value) / RedisCache.put(key, value) [写入缓存]
  │                     │
  │                     ▼
  │               返回目标方法结果
```

---

## 三、 Spring AOP 拦截区分机制：缓存方法 vs 一般函数

在 Spring AOP 底层，**并不是在 Request 运行时动态判断“这个方法要不要触发 CacheInterceptor”**，而是在 **Spring 容器启动（Bean 实例化）阶段** 就已经决定好了每个方法的拦截链。

```text
外部调用 userService.getUserById(1L) 或 userService.calculateAge()
                        │
                        ▼
            CGLIB / JDK 动态代理类拦截
                        │
                        ▼
      DefaultAdvisorChainFactory.getInterceptorsAndDynamicInterceptionAdvice()
                        │
         ┌──────────────┴──────────────┐
         ▼                             ▼
【1. 带有 @Cacheable 的方法】     【2. 一般函数 (无缓存注解)】
 (例如: getUserById)              (例如: calculateAge)
         │                             │
         ▼                             ▼
匹配到 CacheInterceptor           匹配结果为空 (或仅有其他Interceptor)
         │                             │
         ▼                             ▼
执行 CacheInterceptor.invoke()   跳过 CacheInterceptor
   ├── 查 Redis / 缓存           直接执行 Target 原生方法
   ├── 未命中则反射调用 Target
   └── 写回 Redis
```

### 1. 动态代理的拦截链生成
* **带有 `@Cacheable` 的方法**：匹配成功，拦截链中插入 `CacheInterceptor`。
* **一般函数（无缓存注解）**：匹配失败，在代理对象的拦截链缓存中对应的 List 为空（`chain.isEmpty()`）。代理对象直接通过反射/CGLIB FastClass 调用目标方法，**绕过 CacheInterceptor，无额外开销**。

---

## 四、 性能排查指南：Bean 过多与缓存性能瓶颈定位

### 1. 启动阶段瓶颈：容器启动极慢或内存占用过高

* **瓶颈点 A：AOP 匹配扫描开销过大（`BeanPostProcessor` 匹配阶段）**
  * **定位步骤**：`InfrastructureAdvisorAutoProxyCreator`（由 `AutoProxyRegistrar` 注册）会检查 Bean 的每一个方法是否有缓存注解。如果 Bean 数量大且方法多，反射与注解解析会造成启动卡顿。
  * **定位类**：`AnnotationCacheOperationSource.findCacheOperations`
  * **优化手段**：避免在基面或通用接口上加注解，缩小缓存扫描范围；优先考虑在特定的 Service 实现类方法上标注。

* **瓶颈点 B：Cache 实例创建过多（`CacheManager` 初始化阶段）**
  * **优化手段**：收敛 `cacheName` 命名空间，避免动态生成海量无规律的 `cacheName`。

---

### 2. 运行（Request）阶段瓶颈：接口响应延迟（RT 高）或 CPU 飙升

#### 步骤 1：检查 SpEL 表达式解析开销 (`CacheEvaluationContext`)
* **定位类**：`org.springframework.cache.interceptor.ExpressionEvaluator` / `CacheEvaluationContext`。
* **优化手段**：保持 `key` 的 SpEL 尽量简单；避免在 SpEL 中编写复杂逻辑；或直接使用自定义 `KeyGenerator`（纯 Java 拼接，性能优于 SpEL）。

#### 步骤 2：检查序列化/反序列化耗时 (`RedisSerializer`)
* **定位类**：`GenericJackson2JsonRedisSerializer` 或 `JdkSerializationRedisSerializer` 的 `deserialize()` / `serialize()` 方法。
* **优化手段**：避免缓存巨型 DTO/POJO；评估使用更高效的序列化方案；只缓存核心字段。

#### 步骤 3：排查代理对象“内部自调用”导致的缓存失效
* **优化手段**：通过注入自身代理对象，或使用 `AopContext.currentProxy()` 进行内部调用。

#### 步骤 4：排查并发穿透与锁竞争 (`@Cacheable(sync = true)`)
* **定位类**：`org.springframework.data.redis.cache.RedisCache.get(Object key, Callable valueLoader)`。
* **优化手段**：评估使用分布式锁或多级缓存（L1 内存缓存 + L2 Redis）来分散并发压力。