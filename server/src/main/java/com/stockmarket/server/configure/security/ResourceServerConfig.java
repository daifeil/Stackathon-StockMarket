package com.stockmarket.server.configure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: daifeil
 * @Date: Created at 2020-02-10
 * @Description:
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    TokenConverter tokenConverter;

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {

        return tokenConverter.accessTokenConverter();
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/api/v1/**")
                .and().authorizeRequests().anyRequest()
                .authenticated()
                .and().cors();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenServices(tokenServices()).resourceId("stock");
    }
}