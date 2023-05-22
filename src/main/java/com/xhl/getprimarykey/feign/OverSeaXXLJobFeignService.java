package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "oversea-xxljob",  fallbackFactory = OverSeaXXLJobFeignFallbackFactory.class)
public interface OverSeaXXLJobFeignService {

    @GetMapping("/oversea/actuator/info")
    String checkOverSeaXXLJobHealth();

}
