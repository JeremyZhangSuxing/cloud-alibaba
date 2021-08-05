package com.cloudalibaba.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : Knight
 * @date : 2021/8/5 5:48 下午
 */
@Data
public class ProductVo {
    /**
     */
    private Integer id;

    /**
     * 编码
     */
    private String productCode;

    /**
     * 名称
     */
    private String productName;

    /**
     * 库存数量
     */
    private Integer count;

    /**
     * 单价
     */
    private BigDecimal price;

}
