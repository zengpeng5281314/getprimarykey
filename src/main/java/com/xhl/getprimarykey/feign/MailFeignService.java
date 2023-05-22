package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mail",  fallbackFactory = MailFeignFallbackFactory.class)
public interface MailFeignService {

    //查询处置场列表
    @GetMapping("/mail/status/health")
    String checkMailHealth();

}
