package com.cloudalibaba.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : Knight
 * @date : 2021/8/5 5:48 下午
 */
@Data
public class OrderVo {
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

}
