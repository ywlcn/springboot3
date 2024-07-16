package com.sample.config;

import com.sample.common.interceptor.AsyncLogHandlerInterceptor;
import com.sample.common.interceptor.CallableLogProcessingInterceptor;
import com.sample.common.interceptor.DeferredResultLogProcessingInterceptor;
import com.sample.common.listener.LogServletRequestListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AsyncLogHandlerInterceptor());
    }

    // ...
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // ...
        configurer.registerCallableInterceptors(new CallableLogProcessingInterceptor());
        configurer.registerDeferredResultInterceptors(new DeferredResultLogProcessingInterceptor("configureAsyncSupport"));
        configurer.setTaskExecutor(new ConcurrentTaskExecutor());
    }

    @Bean
    LogServletRequestListener logServletRequestListener() {
        return new LogServletRequestListener();
    }


}