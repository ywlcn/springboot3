package com.rgs.security.hello.filter;

import com.rgs.security.hello.configuration.SecurityConfiguration;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@Component
public class MyAuthorizeFilter extends OncePerRequestFilter {

    private final AntPathRequestMatcher matcher = new AntPathRequestMatcher(SecurityConfiguration.LOGIN_URL);

    private final JwtDecoder jwtDecoder;

    public MyAuthorizeFilter(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!matcher.matches(request)) {
            // headersのkeyを指定してトークンを取得します
            String xAuthToken = request.getHeader(SecurityConfiguration.HEADER_AUTH_KEY);

            if (!Strings.isEmpty(xAuthToken)) {
                try {
                    // tokenの検証と認証
                    Jwt jwt = jwtDecoder.decode(xAuthToken);
                    // usernameの取得
                    String username = jwt.getSubject();
                    // roleを取得
                    List<SimpleGrantedAuthority> list = Arrays.stream(jwt.getClaims().get("scope").toString().split(" "))
                            .map(SimpleGrantedAuthority::new).toList();
                    // ログイン状態の設定
                    SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(username, null, list));
                } catch (JwtException ex) {
                    // DoNothing
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}

