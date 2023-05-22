package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sendmail",  fallbackFactory = SendMailFeignFallbackFactory.class)
public interface SendMailFeignService {

    @GetMapping("/sendmail/status/health")
    String checkSendMailHealth();

}
