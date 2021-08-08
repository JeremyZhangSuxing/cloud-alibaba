package com.cloudalibaba.account.facade;

import com.cloudalibaba.order.client.OrderClient;
import com.cloudalibaba.order.vo.OrderVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author suxing.zhang
 * @date 2021/8/8 14:30
 **/
@Component
@RequiredArgsConstructor
public class OrderFacade {
    private final OrderClient orderClient;

    public List<OrderVo> getOrderSByAccountCode(String accountCode) {
        return orderClient.queryOrderOfAccount(accountCode);
    }
}
