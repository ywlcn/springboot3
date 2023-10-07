package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// sqlSessionFactoryRef
@MapperScan(basePackages = {"com.example.demo.mapper"}, sqlSessionTemplateRef = "sqlSessionTemplate", sqlSessionFactoryRef = "sqlSessionFactory")
@SpringBootApplication(proxyBeanMethods = false)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
