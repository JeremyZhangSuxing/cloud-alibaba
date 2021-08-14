package com.cloudalibaba.auth.repository;

import com.cloudalibaba.auth.mybatis.example.UserInfoExample;
import com.cloudalibaba.auth.mybatis.mapper.UserInfoMapper;
import com.cloudalibaba.auth.mybatis.po.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author suxing.zhang
 * @date 2021/8/14 10:23
 **/
@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final UserInfoMapper userInfoMapper;

    public UserInfo queryByUsername(String username) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserNameEqualTo(username);
        return userInfoMapper.selectOneByExample(example);
    }
}
