package com.rgs.security.aouth2.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    public final static String LOGIN_URL = "/login";


    public final static String[] PERMIT_ALL_URL = new String[]{LOGIN_URL};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        {
                            //authorize.requestMatchers(PERMIT_ALL_URL).permitAll();
                            authorize.requestMatchers(("/index")).hasAuthority("SCOPE_springaccess");
                            authorize.anyRequest().authenticated();
                        }
                );
        http.rememberMe(AbstractHttpConfigurer::disable);

        http.oauth2Login(Customizer.withDefaults());
        http.oauth2Client(Customizer.withDefaults());

        return http.build();
    }
}
