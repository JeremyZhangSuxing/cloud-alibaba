package com.cloudalibaba.auth.controller;

import com.cloudalibaba.auth.mybatis.po.UserInfo;
import com.cloudalibaba.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suxing.zhang
 * @date 2021/8/14 11:15
 **/
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/getByName")
    public UserInfo getByName() {
        return userRepository.queryByUsername("zhangjian");
    }

    /**
     * 获取授权的用户信息
     *
     * @param principal 当前用户
     * @return 授权信息
     */
    @GetMapping("/current/get")
    public HttpTrace.Principal user(HttpTrace.Principal principal) {
        return principal;
    }
}
