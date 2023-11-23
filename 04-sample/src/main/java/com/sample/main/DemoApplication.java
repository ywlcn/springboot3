package com.sample.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@MapperScan(basePackages = {"com.sample.**.mapper"},
        sqlSessionTemplateRef = "sqlSessionTemplate",
        sqlSessionFactoryRef = "sqlSessionFactory")
@SpringBootApplication(proxyBeanMethods = false)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
