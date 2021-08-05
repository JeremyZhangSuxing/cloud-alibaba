package com.cloudalibaba.common.handler;

import com.cloudalibaba.common.support.CommonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author suxing.zhang
 * @date 2021/8/5 21:33
 **/
@Slf4j
@ControllerAdvice
public class JsonResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        Object result;
        if (body instanceof CommonResult) {
            result = body;
        } else if (body instanceof String) {
            // 因为StringHttpMessageConverter会直接把字符串写入body, 所以字符串特殊处理
            result = objectMapper.writeValueAsString(CommonResult.success(body));
        } else {
            // 其他类型进行统一包装
            result = CommonResult.success(body);
        }
        return result;
    }
}
