package com.example.demo.cache;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cache.interceptor.BeanFactoryCacheOperationSourceAdvisor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// , PriorityOrdered

@Component
public class CustomCacheAdvisorPostProcessor implements BeanPostProcessor {

    // 1. 白名单：只允许这些类参与 Spring Cache 的 AOP 检查
    private static final List<Class<?>> ALLOWED_CACHE_CLASSES = Arrays.asList(
            // 填入需要开启 @Cacheable 的 Singleton Service
            com.example.demo.service.impl.AddressBookDataServiceImpl.class
            // 其他需要的 Service...
    );

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 2. 拦截 Spring Cache 核心 Advisor 的初始化
        if (bean instanceof BeanFactoryCacheOperationSourceAdvisor) {
            BeanFactoryCacheOperationSourceAdvisor cacheAdvisor = (BeanFactoryCacheOperationSourceAdvisor) bean;

            // 获取原有的 Cache Pointcut
            Pointcut originalPointcut = cacheAdvisor.getPointcut();

            // 3. 构造精准匹配的 ClassFilter
            ClassFilter customClassFilter = new ClassFilter() {
                @Override
                public boolean matches(Class<?> clazz) {
                    return ALLOWED_CACHE_CLASSES.contains(clazz);
                }
            };

            cacheAdvisor.setClassFilter(customClassFilter);

//            // 4. 用装饰器模式重新包装 Pointcut，替换 ClassFilter
//            Pointcut customPointcut = new Pointcut() {
//                @Override
//                public ClassFilter getClassFilter() {
//                    return customClassFilter; // 替换为我们自己的 ClassFilter
//                }
//
//                @Override
//                public org.springframework.aop.MethodMatcher getMethodMatcher() {
//                    return originalPointcut.getMethodMatcher(); // 保持原有的 Cache 注解 MethodMatcher
//                }
//            };
//
//            // 5. 重新设置 Advisor 的 Pointcut
//            cacheAdvisor.setPointcut(customPointcut);
//            System.out.println(" Successfully modified BeanFactoryCacheOperationSourceAdvisor ClassFilter!");
        }
        return bean;
    }

//    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}