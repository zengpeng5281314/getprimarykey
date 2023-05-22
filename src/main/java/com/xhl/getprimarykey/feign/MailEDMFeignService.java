package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mail-edm",  fallbackFactory = MailEDMFeignFallbackFactory.class)
public interface MailEDMFeignService {

    @GetMapping("/mail-edm/status/health")
    String checkMailEDMHealth();

}
