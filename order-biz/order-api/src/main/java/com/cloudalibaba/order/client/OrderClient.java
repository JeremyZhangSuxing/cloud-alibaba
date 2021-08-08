package com.cloudalibaba.order.client;

import com.cloudalibaba.order.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author : Knight
 * @date : 2021/8/5 5:45 下午
 */
@FeignClient("order-service")
@RequestMapping("/rpc/v1/order")
public interface OrderClient {

    /**
     * queryByOrderNo
     *
     * @param accountCode xxxx
     * @return OrderVos
     */
    @GetMapping("/{accountCode}")
    List<OrderVo> queryOrderOfAccount(@PathVariable("accountCode") String accountCode);
}
