package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "piwik",  fallbackFactory = PiwikFeignFallbackFactory.class)
public interface PiwikFeignService {

    @GetMapping("/piwik/actuator/info")
    String checkPiwikhHealth();

}
