package com.cloudalibaba.order.mybatis.po;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ShopOrder {
    /**
     */
    private Integer id;

    /**
     */
    private String orderNo;

    /**
     */
    private String accountCode;

    /**
     */
    private String productCode;

    /**
     */
    private Integer count;

    /**
     */
    private BigDecimal amount;

    /**
     */
    private Boolean deleted;
}