package com.cloudalibaba.order.controller;

import com.cloudalibaba.order.dto.OrderDto;
import com.cloudalibaba.order.service.OrderService;
import com.cloudalibaba.order.vo.OrderVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Knight
 * @date : 2021/8/5 5:44 下午
 */
@RestController
@RequestMapping("/rpc/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{accountCode}")
    public List<OrderVo> queryOrderOfAccount(@PathVariable String accountCode) {
        return orderService.queryOrderOfAccount(accountCode);
    }

    @PutMapping
    public void update(@RequestBody OrderDto orderDto) {

    }

    @PostMapping
    public void create(@RequestBody OrderDto orderDto) {

    }

    @DeleteMapping("/{orderNo}")
    public void delete(@PathVariable String orderNo) {

    }

}
