package com.cloudalibaba.account.mybatis.mapper;

import com.cloudalibaba.account.mybatis.example.AccountExample;
import com.cloudalibaba.account.mybatis.po.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectOneByExample(AccountExample example);

    Account selectOneByExampleForUpdate(AccountExample example);

    List<Account> selectByExampleWithLimit(@Param("example") AccountExample example, @Param("limit") Integer limit);

    List<Account> selectByExampleForUpdate(AccountExample example);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKeyForUpdate(Integer id);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}