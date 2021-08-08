package com.cloudalibaba.account.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : Knight
 * @date : 2021/8/5 4:03 下午
 */
@Data
public class AccountVo {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String accountCode;

    /**
     *
     */
    private String accountName;

    /**
     *
     */
    private BigDecimal amount;
}
