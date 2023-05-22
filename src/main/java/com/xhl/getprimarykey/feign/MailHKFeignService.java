package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mailhk",  fallbackFactory = MailHKFeignFallbackFactory.class)
public interface MailHKFeignService {

    @GetMapping("/mailhk/status/health")
    String checkMailHKHealth();

}
