package com.rgs.security.aouth2.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

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
                        //authorize.requestMatchers(PERMIT_ALL_URL).permitAll()
                        //authorize.requestMatchers(("/index")).hasAuthority("SCOPE_profile")
                        authorize.anyRequest().authenticated()
                );
        http.rememberMe(AbstractHttpConfigurer::disable);

        http.oauth2Login(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("JSESSIONID");
        serializer.setCookiePath("/");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        // HTTPS プロトコル上の暗号化されたリクエストでのみサーバーに送信され、安全でない HTTP では決して送信されない
        serializer.setUseSecureCookie(true);
        return serializer;
    }

}
