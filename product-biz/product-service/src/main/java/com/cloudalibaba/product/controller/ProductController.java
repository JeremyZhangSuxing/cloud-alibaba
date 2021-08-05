package com.cloudalibaba.product.controller;

import com.cloudalibaba.order.vo.ProductVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suxing.zhang
 * @date 2021/8/5 21:22
 **/
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @GetMapping("/{productCode}")
    public ProductVo queryByCode(@PathVariable String productCode) {
        ProductVo productVo = new ProductVo();
        productVo.setProductCode(productCode);
        return productVo;
    }

}
