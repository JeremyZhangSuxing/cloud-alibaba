package com.cloudalibaba.auth.mybatis.mapper;

import com.cloudalibaba.auth.mybatis.example.UserInfoExample;
import com.cloudalibaba.auth.mybatis.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectOneByExample(UserInfoExample example);

    UserInfo selectOneByExampleForUpdate(UserInfoExample example);

    List<UserInfo> selectByExampleWithLimit(@Param("example") UserInfoExample example, @Param("limit") Integer limit);

    List<UserInfo> selectByExampleForUpdate(UserInfoExample example);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKeyForUpdate(Long id);

    UserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}