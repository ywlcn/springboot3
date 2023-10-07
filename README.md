# springboot3



# GraalVM ネイティブイメージのサポート
https://spring.pleiades.io/spring-boot/docs/current/reference/html/native-image.html
https://medium.com/graalvm/using-graalvm-and-native-image-on-windows-10-9954dc071311

マイグレーション：  
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide



インストールしたJVM確認
```bash
PS D:\> java --version
openjdk 17.0.8 2023-07-18
OpenJDK Runtime Environment GraalVM CE 17.0.8+7.1 (build 17.0.8+7-jvmci-23.0-b15)
OpenJDK 64-Bit Server VM GraalVM CE 17.0.8+7.1 (build 17.0.8+7-jvmci-23.0-b15, mixed mode, sharing)
```

VSインストールしていない場合
E:\VSWorkSpace\000-springboot3>gradle nativeCompile

```bash
E:\VSWorkSpace\000-springboot3>gradle nativeCompile
> Task :nativeCompile FAILED
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: JAVA_HOME
[native-image-plugin] Native Image executable path: D:\Tools-Java\graalvm-openjdk-17.0.8+7.1\bin\native-image.cmd
Error: Failed to find 'vcvarsall.bat' in a Visual Studio installation.
Please make sure that Visual Studio 2022 version 17.1.0 or later is installed on your system. You can download it at https://visualstudio.microsoft.com/downloads/. If this error persists, please try and run GraalVM Native Image in an x64 Native Tools Command Prompt or file a ticket.
```


```bash

**********************************************************************
** Visual Studio 2022 Developer Command Prompt v17.7.4
** Copyright (c) 2022 Microsoft Corporation
**********************************************************************
[vcvarsall.bat] Environment initialized for: 'x64'

D:\Tools-.net\Microsoft-Visual-Studio\2022\Professional>cd E:\VSWorkSpace\000-springboot3

D:\Tools-.net\Microsoft-Visual-Studio\2022\Professional>E
'E' 不是内部或外部命令，也不是可运行的程序
或批处理文件。

D:\Tools-.net\Microsoft-Visual-Studio\2022\Professional>E:

E:\VSWorkSpace\000-springboot3>
E:\VSWorkSpace\000-springboot3>gradle nativeCompile

> Task :nativeCompile
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: JAVA_HOME
[native-image-plugin] Native Image executable path: D:\Tools-Java\graalvm-openjdk-17.0.8+7.1\bin\native-image.cmd
=======================================================================================================================
GraalVM Native Image: Generating 'demo' (executable)...
========================================================================================================================For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
Warning: Method com.zaxxer.hikari.HikariConfig.getScheduledExecutorService() not found.---------------------------------<===========--> 90% EXECUTING [7s]
Warning: Method com.zaxxer.hikari.HikariConfig.isInitializationFailFast() not found.
Warning: Method com.zaxxer.hikari.HikariConfig.isJdbc4ConnectionTest() not found.
Warning: Method com.zaxxer.hikari.HikariConfig.setInitializationFailFast(boolean) not found.
Warning: Method com.zaxxer.hikari.HikariConfig.setJdbc4ConnectionTest(boolean) not found.
Warning: Method com.zaxxer.hikari.HikariConfig.setScheduledExecutorService(ScheduledThreadPoolExecutor) not found.
[1/8] Initializing...                                                                                    (8.0s @ 0.22GB)
 Java version: 17.0.8+7, vendor version: GraalVM CE 17.0.8+7.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: cl.exe (microsoft, x64, 19.37.32824)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s)
 - org.springframework.aot.nativex.feature.PreComputeFieldFeature
Field org.apache.commons.logging.LogAdapter#log4jSpiPresent set to true at build time
Field org.apache.commons.logging.LogAdapter#log4jSlf4jProviderPresent set to true at build time
Field org.apache.commons.logging.LogAdapter#slf4jSpiPresent set to true at build time
Field org.apache.commons.logging.LogAdapter#slf4jApiPresent set to true at build time
Field org.springframework.http.converter.json.Jackson2ObjectMapperBuilder#jackson2XmlPresent set to false at build time
Field org.springframework.core.NativeDetector#inNativeImage set to true at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#romePresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#jaxb2Present set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#jackson2Present set to true at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#jackson2XmlPresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#jackson2SmilePresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#jackson2CborPresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#gsonPresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#jsonbPresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#kotlinSerializationCborPresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#kotlinSerializationJsonPresent set to false at build time
Field org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#kotlinSerializationProtobufPresent set to false at build time
Field org.springframework.web.client.RestTemplate#romePresent set to false at build time
Field org.springframework.web.client.RestTemplate#jaxb2Present set to false at build time
Field org.springframework.web.client.RestTemplate#jackson2Present set to true at build time
Field org.springframework.web.client.RestTemplate#jackson2XmlPresent set to false at build time
Field org.springframework.web.client.RestTemplate#jackson2SmilePresent set to false at build time
Field org.springframework.web.client.RestTemplate#jackson2CborPresent set to false at build time
Field org.springframework.web.client.RestTemplate#gsonPresent set to false at build time
Field org.springframework.web.client.RestTemplate#jsonbPresent set to false at build time
Field org.springframework.web.client.RestTemplate#kotlinSerializationCborPresent set to false at build time
Field org.springframework.web.client.RestTemplate#kotlinSerializationJsonPresent set to false at build time
Field org.springframework.web.client.RestTemplate#kotlinSerializationProtobufPresent set to false at build time
Field org.springframework.web.servlet.view.InternalResourceViewResolver#jstlPresent set to false at build time
Field org.springframework.transaction.interceptor.TransactionAspectSupport#vavrPresent set to false at build time
Field org.springframework.transaction.interceptor.TransactionAspectSupport#reactiveStreamsPresent set to true at build time
Field org.springframework.cglib.core.AbstractClassGenerator#inNativeImage set to true at build time
Field org.springframework.boot.logging.logback.LogbackLoggingSystem$Factory#PRESENT set to true at build time
Field org.springframework.boot.logging.java.JavaLoggingSystem$Factory#PRESENT set to true at build time
Field org.springframework.boot.logging.log4j2.Log4J2LoggingSystem$Factory#PRESENT set to false at build time
Field org.springframework.aot.AotDetector#inNativeImage set to true at build time
Field org.springframework.core.KotlinDetector#kotlinPresent set to false at build time
Field org.springframework.core.KotlinDetector#kotlinReflectPresent set to false at build time
Field org.springframework.format.support.DefaultFormattingConversionService#jsr354Present set to false at build time
Field org.springframework.web.context.support.StandardServletEnvironment#jndiPresent set to true at build time
Field org.springframework.web.context.support.WebApplicationContextUtils#jsfPresent set to false at build time
Field org.springframework.web.context.request.RequestContextHolder#jsfPresent set to false at build time
Field org.springframework.boot.logging.logback.LogbackLoggingSystemProperties#JBOSS_LOGGING_PRESENT set to false at build time
Field org.springframework.core.ReactiveAdapterRegistry#reactorPresent set to true at build time
Field org.springframework.core.ReactiveAdapterRegistry#rxjava3Present set to false at build time
Field org.springframework.core.ReactiveAdapterRegistry#kotlinCoroutinesPresent set to false at build time
Field org.springframework.core.ReactiveAdapterRegistry#mutinyPresent set to false at build time
Field org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#jta12Present set to false at build time
Field org.springframework.transaction.annotation.AnnotationTransactionAttributeSource#ejb3Present set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#jaxb2Present set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#jackson2Present set to true at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#jackson2XmlPresent set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#jackson2SmilePresent set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#gsonPresent set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#jsonbPresent set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#kotlinSerializationCborPresent set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#kotlinSerializationJsonPresent set to false at build time
Field org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter#kotlinSerializationProtobufPresent set to false at build time
Field org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator#userProvidedErrorCodesFilePresent set to false at build time
Field org.springframework.context.event.ApplicationListenerMethodAdapter#reactiveStreamsPresent set to true at build time
Field org.springframework.context.annotation.AnnotationConfigUtils#jakartaAnnotationsPresent set to true at build time
Field org.springframework.context.annotation.AnnotationConfigUtils#jsr250Present set to false at build time
Field org.springframework.context.annotation.AnnotationConfigUtils#jpaPresent set to false at build time
Field org.springframework.context.annotation.CommonAnnotationBeanPostProcessor#jndiPresent set to true at build time
Field org.springframework.boot.jdbc.DataSourceUnwrapper#DELEGATING_DATA_SOURCE_PRESENT set to true at build time
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Field org.springframework.web.servlet.mvc.method.annotation.ReactiveTypeHandler#isContextPropagationPresent set to true at build time
Field org.springframework.boot.autoconfigure.web.format.WebConversionService#JSR_354_PRESENT set to false at build time
Field org.springframework.web.servlet.support.RequestContext#jstlPresent set to false at build time
Field org.springframework.graphql.execution.SecurityContextThreadLocalAccessor#springSecurityPresent set to false at build time
[2/8] Performing analysis...  [******]                                                                  (41.0s @ 2.48GB)
  18,978 (91.17%) of 20,815 types reachable
  32,584 (67.76%) of 48,087 fields reachable
  98,246 (64.51%) of 152,293 methods reachable
   5,768 types,   370 fields, and 6,279 methods registered for reflection
      85 types,    78 fields, and    70 methods registered for JNI access
       5 native libraries: crypt32, ncrypt, psapi, version, winhttp
[3/8] Building universe...                                                                               (6.0s @ 1.60GB)
[4/8] Parsing methods...      [**]                                                                       (3.6s @ 2.69GB)
[5/8] Inlining methods...     [****]                                                                     (2.4s @ 1.94GB)
[6/8] Compiling methods...    [*****]                                                                   (32.0s @ 5.27GB)
[7/8] Layouting methods...    [***]                                                                      (5.5s @ 3.32GB)
[8/8] Creating image...       [***]                                                                      (5.7s @ 4.23GB)
  49.73MB (55.10%) for code area:    65,521 compilation units
  40.00MB (44.32%) for image heap:  431,629 objects and 194 resources
 537.20kB ( 0.58%) for other data
  90.26MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
  13.86MB java.base                                           10.98MB byte[] for code metadata
   5.94MB h2-2.1.214.jar                                       4.63MB java.lang.Class
   4.56MB tomcat-embed-core-10.1.13.jar                        4.28MB java.lang.String
   4.21MB java.xml                                             3.70MB byte[] for java.lang.String
   2.05MB jackson-databind-2.15.2.jar                          3.51MB byte[] for general heap data
   1.64MB spring-core-6.0.12.jar                               2.00MB byte[] for embedded resources
   1.49MB svm.jar (Native Image)                               1.59MB com.oracle.svm.core.hub.DynamicHubCompanion
   1.40MB spring-boot-3.1.4.jar                                1.16MB byte[] for reflection metadata
   1.01MB spring-beans-6.0.12.jar                            885.07kB java.lang.String[]
 940.87kB spring-web-6.0.12.jar                              680.04kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
  12.18MB for 92 more packages                                 6.51MB for 3665 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                        7.2s (6.8% of total time) in 103 GCs | Peak RSS: 7.49GB | CPU load: 8.69
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 E:\VSWorkSpace\000-springboot3\build\native\nativeCompile\demo.exe (executable)
 E:\VSWorkSpace\000-springboot3\build\native\nativeCompile\jaas.dll (jdk_library)
 E:\VSWorkSpace\000-springboot3\build\native\nativeCompile\w2k_lsa_auth.dll (jdk_library)
========================================================================================================================
Finished generating 'demo' in 1m 45s.
[native-image-plugin] Native Image written to: E:\VSWorkSpace\000-springboot3\build\native\nativeCompile

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.2.1/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

```



 Mytatis
 https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start-for-building-native-image
 ```
   .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2023-10-07T08:32:58.543+09:00  INFO 4552 --- [           main] com.example.demo.DemoApplication         : Starting AOT-processed DemoApplication using Java 17.0.8 with PID 4552 (E:\VSWorkSpace\000-springboot3\build\native\nativeCompile\demo.exe started by Administrator in E:\VSWorkSpace\000-springboot3)
2023-10-07T08:32:58.543+09:00  INFO 4552 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2023-10-07T08:32:58.546+09:00 ERROR 4552 --- [           main] o.s.boot.SpringApplication               : Application run failed

java.lang.ExceptionInInitializerError: null
        at org.mybatis.spring.mapper.MapperScannerConfigurer.postProcessBeanDefinitionRegistry(MapperScannerConfigurer.java:363) ~[demo.exe:na]
        at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:344) ~[na:na]
        at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:145) ~[na:na]
        at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:771) ~[demo.exe:6.0.12]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:589) ~[demo.exe:6.0.12]
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[demo.exe:3.1.4]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:737) ~[demo.exe:3.1.4]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[demo.exe:3.1.4]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[demo.exe:3.1.4]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1309) ~[demo.exe:3.1.4]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1298) ~[demo.exe:3.1.4]
        at com.example.demo.DemoApplication.main(DemoApplication.java:12) ~[demo.exe:na]
Caused by: org.apache.ibatis.logging.LogException: Error creating logger for logger org.mybatis.spring.mapper.ClassPathMapperScanner.  Cause: java.lang.NullPointerException
        at org.apache.ibatis.logging.LogFactory.getLog(LogFactory.java:54) ~[na:na]
        at org.apache.ibatis.logging.LogFactory.getLog(LogFactory.java:47) ~[na:na]
        at org.mybatis.logging.LoggerFactory.getLogger(LoggerFactory.java:32) ~[na:na]
        at org.mybatis.spring.mapper.ClassPathMapperScanner.<clinit>(ClassPathMapperScanner.java:62) ~[na:na]
        ... 12 common frames omitted
Caused by: java.lang.NullPointerException: null
        at org.apache.ibatis.logging.LogFactory.getLog(LogFactory.java:52) ~[na:na]
        ... 15 common frames omitted
 ```