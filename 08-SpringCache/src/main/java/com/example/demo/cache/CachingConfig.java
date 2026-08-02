package com.example.demo.cache;

import com.example.demo.service.impl.AddressBookDataServiceImpl;
import org.springframework.aop.ClassFilter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.BeanFactoryCacheOperationSourceAdvisor;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean(value = "cacheManager")
    public CacheManager cacheManager() {
//        BeanFactoryCacheOperationSourceAdvisor
//        List<Class> listClass = new ArrayList<>();
//        listClass.add(AddressBookDataServiceImpl.class);
//
//        ClassFilter filter = new ClassFilter() {
//            @Override
//            public boolean matches(Class<?> clazz) {
//                return listClass.contains(clazz);
//            }
//        };



//        advisor.setClassFilter(filter);


        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("directory"),
                new ConcurrentMapCache("addresses")));
        return cacheManager;
    }
}