package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "piwikRead",  fallbackFactory = PiwikReadFeignFallbackFactory.class)
public interface PiwikReadFeignService {

    @GetMapping("/piwikRead/actuator/info")
    String checkPiwikReadHealth();

}
