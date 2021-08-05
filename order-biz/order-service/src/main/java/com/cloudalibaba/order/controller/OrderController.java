package com.cloudalibaba.order.controller;

import com.cloudalibaba.order.dto.OrderDto;
import com.cloudalibaba.order.vo.OrderVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Knight
 * @date : 2021/8/5 5:44 下午
 */
@RestController
@RequestMapping("/ap1/v1/order")
public class OrderController {


    @GetMapping("/{orderNo}")
    public OrderVo queryById(@PathVariable String orderNo) {
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderNo);
        return orderVo;
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
