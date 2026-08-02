package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ConcurrentOperationExecutor concurrentOperationExecutor() {
        ConcurrentOperationExecutor executor = new ConcurrentOperationExecutor();
        executor.setMaxRetries(3);
        executor.setOrder(100);
        return executor;

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // すべてのリクエストに対して適用
//        registry.addInterceptor(new MyRenderInterceptor());

        // 特定のパスパターンに対してのみ適用することも可能
        // registry.addInterceptor(new MyRenderInterceptor()).addPathPatterns("/app/**");
    }
}