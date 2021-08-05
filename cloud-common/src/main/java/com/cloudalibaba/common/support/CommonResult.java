package com.cloudalibaba.common.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author suxing.zhang
 * @date 2021/8/5 21:39
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static <T> CommonResult success(T data) {
        CommonResult commonResult = new CommonResult(0, "success", data);
        return commonResult;
    }
}
