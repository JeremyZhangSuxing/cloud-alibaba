package com.cloudalibaba.order.client;

import com.cloudalibaba.order.vo.ProductVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Knight
 * @date : 2021/8/5 5:45 下午
 */
@FeignClient("productService")
@RequestMapping("/rpc/v1")
public interface ProductClient {

    @GetMapping("/{productCode}")
    ProductVo queryByCode(@PathVariable("productCode") String productCode);

}
