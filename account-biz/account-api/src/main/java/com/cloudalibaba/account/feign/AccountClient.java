package com.cloudalibaba.account.feign;

import com.cloudalibaba.account.vo.AccountVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author : Knight
 * @date : 2021/8/5 4:01 下午
 */
@FeignClient("accountClient")
public interface AccountClient {

    @GetMapping("/api/v1/accounts/{id}")
    List<AccountVo> listAccount(@PathVariable(value = "id") String id);
}
