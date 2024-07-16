package com.sample.config;

import com.sample.common.filter.GraphqlFilter;
import com.sample.common.filter.LogFilter;
import com.sample.common.filter.RequestIdFilter;
import com.sample.common.interceptor.WebGraphQlLogInterceptor;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.method.annotation.support.AnnotatedControllerConfigurer;
import org.springframework.graphql.data.method.annotation.support.GraphqlLogInstrument;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration(proxyBeanMethods = false)
public class GraphqlConfig {

    @Bean
    public FilterRegistrationBean<GraphqlFilter> graphqlFilter() {
        GraphqlFilter graphqlFilter = new GraphqlFilter();
        FilterRegistrationBean<GraphqlFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(graphqlFilter);
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<RequestIdFilter> requestIdFilter() {
        RequestIdFilter requestIdFilter = new RequestIdFilter();
        FilterRegistrationBean<RequestIdFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(requestIdFilter);
        registration.setOrder(0);
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<LogFilter> logFilter() {
        LogFilter logFilter = new LogFilter();
        FilterRegistrationBean<LogFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(logFilter);
        registration.setOrder(2);
        registration.setAsyncSupported(true);// false: 設定すると　エラーになる
        registration.setDispatcherTypes(DispatcherType.ASYNC,DispatcherType.REQUEST,DispatcherType.ERROR,DispatcherType.FORWARD);
        return registration;
    }

    @Bean
    ExecutorService executorService(AnnotatedControllerConfigurer annotatedControllerConfigurer) {
        ExecutorService ExecutorService = Executors.newFixedThreadPool(10);
        annotatedControllerConfigurer.setExecutor(ExecutorService);
        return ExecutorService;
    }

    @Bean
    WebGraphQlLogInterceptor logGraphqlInterceptor002() {
        return new WebGraphQlLogInterceptor(200);
    }

    @Bean
    WebGraphQlLogInterceptor logGraphqlInterceptor001() {
        return new WebGraphQlLogInterceptor(20);
    }


    @Bean
    GraphqlLogInstrument graphqlLogInstrument001() {
        return new GraphqlLogInstrument(100);
    }

//    @Bean
//    GraphqlInstrument2 graphqlInstrument2() {
//        return new GraphqlInstrument2();
//    }




}

