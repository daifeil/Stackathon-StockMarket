package com.stockmarket.server.configure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

/**
 * @Author: daifeil
 * @Date: Created at 2020-02-10
 * @Description:
 */
@Component
public class TokenConverter {
    @Value("${oauth.security.sign-key}")
    private String signingKey;
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        converter.setSigningKey(signingKey);
        return converter;
    }
}