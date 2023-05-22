package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "instagram",  fallbackFactory = InstagramFeignFallbackFactory.class)
public interface InstagramFeignService {

    @GetMapping("/instagram/actuator/info")
    String checkInstagramHealth();

}
