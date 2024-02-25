package com.rgs.security.test.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.CrossOriginEmbedderPolicyHeaderWriter;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> {
                    authorize.requestMatchers("/login").permitAll();
                    authorize.anyRequest().authenticated();
                }
        );

        http.headers(header -> {
            header.crossOriginEmbedderPolicy(policy -> policy.policy(CrossOriginEmbedderPolicyHeaderWriter.CrossOriginEmbedderPolicy.UNSAFE_NONE));
        });


        http.formLogin(Customizer.withDefaults());
        http.sessionManagement((session) ->
                {
                    // https://spring.pleiades.io/spring-security/reference/servlet/authentication/session-management.html#ns-session-fixation
                    //再度認証時、何もしない
                    //session.sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::none);
                    //再度認証時、新Session生成
//                    session.sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::newSession);
                    //再度認証時、SessionId変更
                    session.sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::changeSessionId);
                    //再度認証時、SessionId変更
//                    session.sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::migrateSession);
                }
        );


        http.csrf(csrf -> {
            csrf.ignoringRequestMatchers("/login");
            csrf.csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler());
            csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
        });

        http.rememberMe(rememberMe -> {
            rememberMe.useSecureCookie(true);
        });

        return http.build();
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID");
        serializer.setCookiePath("/");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        serializer.setUseSecureCookie(true);
        return serializer;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123456")
                .roles("normal")
                .build();

        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }


}
