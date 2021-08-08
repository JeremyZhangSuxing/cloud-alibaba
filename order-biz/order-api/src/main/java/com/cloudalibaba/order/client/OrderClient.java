package com.cloudalibaba.order.client;

import com.cloudalibaba.order.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Knight
 * @date : 2021/8/5 5:45 下午
 */
@FeignClient("orderService")
@RequestMapping("/rpc/v1")
public interface OrderClient {
    @GetMapping("/{orderNo}")
    OrderVo queryByOrderNo();
}
