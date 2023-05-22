package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "minor",  fallbackFactory = MinorFeignFallbackFactory.class)
public interface MinorFeignService {

    @GetMapping("/minor/actuator/info")
    String checkMinorHealth();

}
