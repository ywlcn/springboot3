package com.rgs.security.hello.controller;

import com.rgs.security.hello.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private DaoAuthenticationProvider daoAuthenticationProvider;

    @Autowired
    JwtEncoder encoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(UserEntity user) {

        //DaoAuthenticationProviderを用いた認証を行う
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authentication = daoAuthenticationProvider.authenticate(authenticationToken);

        Instant now = Instant.now();
        long expiry = 36000L;
        // @formatter:off
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        // @formatter:on
        return new ResponseEntity<>(this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue(), HttpStatus.OK);
    }
}