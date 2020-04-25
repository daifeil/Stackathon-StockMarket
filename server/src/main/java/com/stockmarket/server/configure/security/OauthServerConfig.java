package com.stockmarket.server.configure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
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
    @EnableAuthorizationServer
    public class OauthServerConfig extends AuthorizationServerConfigurerAdapter {

        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        TokenConverter tokenConverter;
        @Bean
        public JwtAccessTokenConverter accessTokenConverter() {
            return tokenConverter.accessTokenConverter();
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            String[] grantTypes={"password", "refresh_token"};
            clients.inMemory().withClient("stock")
                    .secret(new BCryptPasswordEncoder().encode("secret"))//encrypt secret code because security upgraded
                    .resourceIds("stock")
                    .authorizedGrantTypes(grantTypes)
                    .authorities("ROLE_CLIENT")
                    .scopes("read", "write")
                    .refreshTokenValiditySeconds(3600*24*7)
                    .accessTokenValiditySeconds(3600*24);
        }

        @Bean
        public TokenStore tokenStore() {
            return new JwtTokenStore(accessTokenConverter());
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)  {

            endpoints.accessTokenConverter(accessTokenConverter());
            endpoints.tokenStore(tokenStore());
            endpoints.authenticationManager(authenticationManager);
        }
        @Bean
        @Primary
        public DefaultTokenServices tokenServices() {
            DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
            defaultTokenServices.setTokenStore(tokenStore());
            defaultTokenServices.setSupportRefreshToken(true);
            return defaultTokenServices;
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            oauthServer.tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()")
                    .allowFormAuthenticationForClients();
        }
}
