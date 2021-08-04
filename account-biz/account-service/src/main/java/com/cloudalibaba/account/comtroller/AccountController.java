package com.cloudalibaba.account.comtroller;

import com.cloudalibaba.account.mybatis.example.AccountExample;
import com.cloudalibaba.account.mybatis.mapper.AccountMapper;
import com.cloudalibaba.account.mybatis.po.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Knight  git config --global http.sslVerify "false"
 * @date : 2021/8/3 3:07 下午
 */
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountMapper accountMapper;

    @GetMapping("/api/v1/accounts")
    public List<Account> listAccount() {
        AccountExample example = new AccountExample();
        return accountMapper.selectByExample(example.createCriteria().andDeletedEqualTo(Boolean.FALSE).example());
    }
}
