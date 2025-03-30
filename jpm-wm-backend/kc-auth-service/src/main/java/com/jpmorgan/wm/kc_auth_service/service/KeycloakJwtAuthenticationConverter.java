package com.jpmorgan.wm.kc_auth_service.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class KeycloakJwtAuthenticationConverter  implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        return new KeycloakJwtAuthenticationToken(jwt, extractAuthorities(jwt));
    }

    private Collection<? extends GrantedAuthority> extractAuthorities(Jwt jwt) {
        // Extract roles from "realm_access" or "resource_access" claims
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
