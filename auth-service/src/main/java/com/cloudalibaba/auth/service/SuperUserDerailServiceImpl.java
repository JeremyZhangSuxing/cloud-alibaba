package com.cloudalibaba.auth.service;

import com.cloudalibaba.auth.mybatis.po.UserInfo;
import com.cloudalibaba.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author suxing.zhang
 * @date 2021/8/12 21:29
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class SuperUserDerailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取本地用户
        UserInfo user = userRepository.queryByUsername(username);
        if (user != null) {
            //返回oauth2的用户
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getPassWord(),
                    AuthorityUtils.createAuthorityList(user.getRole()));
        } else {
            throw new UsernameNotFoundException("用户[" + username + "]不存在");
        }
    }
}
