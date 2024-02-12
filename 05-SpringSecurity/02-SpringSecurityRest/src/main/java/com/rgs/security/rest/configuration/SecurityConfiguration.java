package com.rgs.security.rest.configuration;

import com.rgs.security.rest.filter.MyAuthorizeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.header.HeaderWriterFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public final static String LOGIN_URL = "/login";
    public final static String HEADER_AUTH_KEY = "X-AUTH-TOKEN";

    public final static String[] PERMIT_ALL_URL = new String[]{LOGIN_URL};

    @Value("${jwt.public.key}")
    RSAPublicKey key;

    @Value("${jwt.private.key}")
    RSAPrivateKey priv;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtDecoder jwtDecoder) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers(PERMIT_ALL_URL).permitAll()
                                .requestMatchers("admin").hasRole("admin")
                                .anyRequest().authenticated()

                )
//                .csrf((csrf) -> csrf.ignoringRequestMatchers("/token"))
//                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(jwt -> {
                    jwt.jwt(Customizer.withDefaults());
                })
                .addFilterAfter(new MyAuthorizeFilter(jwtDecoder), HeaderWriterFilter.class)
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable);

        //                .exceptionHandling((exceptions) -> exceptions
//                                .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//                                .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("normal")
                .build();

        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        // CORSの設定を有効化...(1)
//        http.cors(cores -> {
////            cores.configurationSource(corsConfigurationSource());
//            cores.disable();
//        });
//
//        // csrf設定を無効化。...(2)
//        http.csrf(csrf -> {
//            csrf.disable();
//        });
//
//        // (3)
//        http.authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/").permitAll()
//                .anyRequest().authenticated());
//        //http.addFilterBefore(new AuthorizeFilter(), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

//    // (4)
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    // (5)
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService loginUserDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(loginUserDetailsService);
        provider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        return provider;
    }

//    // CORSの設定
//    private CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
//        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
//        // クロスドメインのリクエストに対してX-AUTH-TOKENヘッダーでトークンを返すように設定しています。
//        corsConfiguration.addExposedHeader("X-AUTH-TOKEN");
//        corsConfiguration.addAllowedOrigin("http://front-origin.example.com");
//        corsConfiguration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
//        corsSource.registerCorsConfiguration("/**", corsConfiguration);
//        return corsSource;
//    }


    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

}
