package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "delayquenecn",  fallbackFactory = DelayQueneCNFeignFallbackFactory.class)
public interface DelayQueneCNFeignService {

    @GetMapping("/delayquene/actuator/info")
    String checkDelayQueneCNHealth();

}
