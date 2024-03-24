package com.rgs.security.aouth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rgs.utils", "com.rgs.security"})
public class OAuth2SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2SecurityApplication.class, args);
    }

}
