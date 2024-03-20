package com.rgs.security.aouth2.service;


import com.rgs.security.aouth2.dao.MyUserRepository;
import com.rgs.security.aouth2.service.dto.MyOidcUser;
import com.rgs.security.aouth2.service.dto.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WebOidcUserService extends OidcUserService {

    private final MyUserRepository myUserRepository;

    // ROLEプレフィックス
    private final String ROLE_PREFIX = "ROLE_";

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        var oidcUser = super.loadUser(userRequest);
        var username = oidcUser.getPreferredUsername();

        // DBからユーザー情報・ロールを取得する
        MyUser myUser = myUserRepository.findByName(username);
        // ロールの付与
        List<GrantedAuthority> authList = myUser.getRoleList()
                .stream()
                .map(role -> new OAuth2UserAuthority(ROLE_PREFIX + role.getUserRoleId().getRoleName(), oidcUser.getAttributes()))
                .toList();

        return new MyOidcUser(authList, userRequest.getIdToken(), oidcUser.getUserInfo(), myUser);
    }

}
