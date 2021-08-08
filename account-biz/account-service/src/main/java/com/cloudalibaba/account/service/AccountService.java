package com.cloudalibaba.account.service;

import com.cloudalibaba.account.facade.OrderFacade;
import com.cloudalibaba.account.mybatis.mapper.AccountMapper;
import com.cloudalibaba.order.vo.OrderVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Knight
 * @date : 2021/8/3 2:56 下午
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final OrderFacade orderFacade;
    private final AccountMapper accountMapper;

    public List<OrderVo> getOrderSByAccountCode(String accountCode) {
        //获取当前登录用户的账号-->code--->orders 暂时不做
        return orderFacade.getOrderSByAccountCode(accountCode);
    }
}
