package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "receivemail",  fallbackFactory = ReceiveMailFeignFallbackFactory.class)
public interface ReceiveMailFeignService {

    @GetMapping("/receivemail/status/health")
    String checkReceiveMailHealth();

}
