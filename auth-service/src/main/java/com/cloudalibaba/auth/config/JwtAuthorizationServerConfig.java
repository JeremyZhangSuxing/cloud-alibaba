package com.cloudalibaba.auth.config;

import com.cloudalibaba.auth.service.SuperUserDerailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

/**
 * @author suxing.zhang
 * @date 2021/8/18 20:10
 **/
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class JwtAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final SuperUserDerailServiceImpl userDetailService;
    private final AuthenticationManager authenticationManager;
    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public TokenStore tokenStore() {
        //return new JdbcTokenStore(dataSource);
        return new JwtTokenStore(jwtTokenEnhancer());
    }


    /**
     * JwtAccessTokenConverter
     * TokenEnhancer的子类，帮助程序在JWT编码的令牌值和OAuth身份验证信息之间进行转换。
     */
    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 设置对称签名
        converter.setSigningKey("javadaily");
        return converter;
    }

    /**
     * 从数据库读取clientDetails相关配置
     * 有InMemoryClientDetailsService 和 JdbcClientDetailsService 两种方式选择
     */
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 注入密码加密实现器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 认证服务器相关接口权限管理
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients() //如果使用表单认证则需要加上
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     * client存储方式，此处使用jdbc存储
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //如果需要使用refresh_token模式则需要注入userDetailService
        endpoints.authenticationManager(this.authenticationManager)
                .userDetailsService(userDetailService)
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtTokenEnhancer())
                //注入自定义的tokenService
                .tokenServices(tokenServices());
    }

    @Primary
    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenEnhancer(jwtTokenEnhancer());
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        //设置token有效期，默认12小时，此处修改为6小时   21600
        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 6);
        //设置refresh_token的有效期，默认30天，此处修改为7天
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
        return tokenServices;
    }
}
