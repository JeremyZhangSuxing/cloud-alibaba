package com.cloudalibaba.account.mybatis.po;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Order {
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