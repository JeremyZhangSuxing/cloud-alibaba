package com.cloudalibaba.order.service;

import com.cloudalibaba.order.mybatis.example.ShopOrderExample;
import com.cloudalibaba.order.mybatis.mapper.ShopOrderMapper;
import com.cloudalibaba.order.mybatis.po.ShopOrder;
import com.cloudalibaba.order.vo.OrderVo;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Knight
 * @date : 2021/8/5 5:43 下午
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final ShopOrderMapper shopOrderMapper;

    public List<OrderVo> queryOrderOfAccount(String accountCode) {
        ShopOrderExample orderExample = new ShopOrderExample();
        orderExample.createCriteria()
                .andAccountCodeEqualTo(accountCode).example();
        List<ShopOrder> orders = shopOrderMapper.selectByExample(orderExample);
        List<OrderVo> orderVos = Lists.newArrayList();
        for (ShopOrder order : orders) {
            OrderVo orderVo = new OrderVo();
            BeanUtils.copyProperties(order, orderVo);
            orderVos.add(orderVo);
        }
        return orderVos;

    }
}
