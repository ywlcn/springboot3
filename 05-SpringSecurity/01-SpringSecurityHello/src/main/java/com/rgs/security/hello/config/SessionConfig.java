package com.rgs.security.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.session.SessionIdGenerator;

//@Configuration
public class SessionConfig {

    @Bean
    public SessionIdGenerator sessionIdGenerator() {
        return new MySessionIdGenerator();
    }

    static class MySessionIdGenerator implements SessionIdGenerator {

        @Override
        public String generate() {
            return "ZZZZZZZZZZZZZZZZZZZZZZ";
        }
    }


}
