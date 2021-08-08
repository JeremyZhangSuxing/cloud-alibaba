package com.cloudalibaba.account.vo;

import com.cloudalibaba.order.vo.OrderVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

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

    private List<OrderVo> orders;
}