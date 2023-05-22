package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mailxxljob",  fallbackFactory = MailXXLJOBFeignFallbackFactory.class)
public interface MailXXLJOBFeignService {

    @GetMapping("/mailxxljob/status/health")
    String checkMailXXLJOBHealth();

}
