package com.rgs.security.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rgs.utils")
public class HelloSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSecurityApplication.class, args);
    }
}
