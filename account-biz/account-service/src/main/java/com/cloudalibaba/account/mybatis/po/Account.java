package com.cloudalibaba.account.mybatis.po;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Account {
    /**
     */
    private Integer id;

    /**
     */
    private String accountCode;

    /**
     */
    private String accountName;

    /**
     */
    private BigDecimal amount;

    /**
     */
    private Boolean deleted;
}