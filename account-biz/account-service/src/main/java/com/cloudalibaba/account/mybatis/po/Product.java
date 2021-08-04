package com.cloudalibaba.account.mybatis.po;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Product {
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

    /**
     */
    private Boolean deleted;
}