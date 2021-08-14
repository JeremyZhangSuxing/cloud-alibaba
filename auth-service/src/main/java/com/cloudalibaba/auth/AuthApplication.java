package com.cloudalibaba.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author suxing.zhang
 * @date 2021/8/12 21:13
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class AuthApplication {
    /**
     * 对外开启暴露获取token的API接口
     */
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
