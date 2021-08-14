package com.cloudalibaba.auth;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author suxing.zhang
 * @date 2021/8/14 15:24
 **/
@Slf4j
@SpringBootTest
public class AuthTest {

    @Test
    public void testPasswordEncoder() {
        //原始密码  $2a$10$nQMZ9wHb1nJ6ZxhHZ0pZ6OEvE/p5uigGamC.FHGRQbLHlBUsoU41O
        String password = "app";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //使用BCrypt加密，每次加密使用一个随机盐
        String encode = encoder.encode(password);
        System.out.println(encode);
        boolean matches = encoder.matches(password, "$2a$10$fG7ou8CNxDESVFLIM7LrneDmIpwbrxGM2W6.coGPddfQPyZxiqXE6");
        System.out.println(matches);
    }

}
