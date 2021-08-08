package com.cloudalibaba.account.controller;

import com.cloudalibaba.account.dto.AccountDto;
import com.cloudalibaba.account.mybatis.example.AccountExample;
import com.cloudalibaba.account.mybatis.mapper.AccountMapper;
import com.cloudalibaba.account.mybatis.po.Account;
import com.cloudalibaba.account.vo.AccountVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Knight  git config --global http.sslVerify "false"
 * @date : 2021/8/3 3:07 下午
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountMapper accountMapper;

    @GetMapping("/accounts")
    public List<Account> listAccount() {
        AccountExample example = new AccountExample();
        return accountMapper.selectByExample(example.createCriteria().andDeletedEqualTo(Boolean.FALSE).example());
    }

    @GetMapping("/account/{accountCode}")
    public AccountVo queryById(@PathVariable String accountCode) {
        AccountExample example = new AccountExample();
        Account account = accountMapper.selectOneByExample(example.createCriteria().andAccountCodeEqualTo(accountCode).example());
        AccountVo accountVo = new AccountVo();
        BeanUtils.copyProperties(account,accountVo);
        return accountVo;
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDto accountDto) {

    }

    @PostMapping("account")
    public void create(@RequestBody AccountDto accountDto) {

    }

    @DeleteMapping("/account/{accountCode}")
    public void delete(@PathVariable String accountCode) {

    }
}
