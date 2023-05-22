package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "p-gateway",  fallbackFactory = PGatewayFeignFallbackFactory.class)
public interface PGatewayFeignService {

    @GetMapping("actuator/info")
    String checkPGatewayHealth();

}
