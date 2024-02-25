package com.rgs.security.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rgs.utils","com.rgs.security.test"})
public class TestSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestSecurityApplication.class, args);
    }
}
