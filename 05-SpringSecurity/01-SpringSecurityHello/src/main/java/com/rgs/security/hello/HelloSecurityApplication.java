package com.rgs.security.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@SpringBootApplication
@ComponentScan("com.rgs.utils")
public class HelloSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSecurityApplication.class, args);
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONIDAA");
        serializer.setCookiePath("/");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        serializer.setUseSecureCookie(false);
        serializer.setUseHttpOnlyCookie(false);
        serializer.setSameSite("");
        return serializer;
    }

}
