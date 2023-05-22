package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "oversea",  fallbackFactory = OverSeaFeignFallbackFactory.class)
public interface OverSeaFeignService {

    @GetMapping("/oversea/actuator/info")
    String checkOverseaHealth();

}
