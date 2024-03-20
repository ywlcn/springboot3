package com.rgs.security.aouth2.configuration;

import com.rgs.security.aouth2.service.dto.MyOidcUser;
import com.rgs.security.aouth2.service.WebOidcUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    public final static String LOGIN_URL = "/login";

    private final WebOidcUserService userService;

    public final static String[] PERMIT_ALL_URL = new String[]{LOGIN_URL};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(PERMIT_ALL_URL).permitAll()
                                .anyRequest().authenticated()

                );

//        http.oauth2Login(f -> {
//            f.userInfoEndpoint(g ->{
//                g.userService(userService);
//            });
//
//        });

        return http.build();
    }

    public static MyOidcUser getLoginUser() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof MyOidcUser) {
            return (MyOidcUser) principal;
        }
        throw new RuntimeException("認証情報の取得に失敗しました。");
    }

}
