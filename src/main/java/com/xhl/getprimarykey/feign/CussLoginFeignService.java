package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cuss-login",  fallbackFactory = CussLoginFeignFallbackFactory.class)
public interface CussLoginFeignService {

    @GetMapping("/cuss-login/actuator/info")
    String checkCussLoginHealth();

}
