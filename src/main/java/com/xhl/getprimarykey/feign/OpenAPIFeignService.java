package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "openapi",  fallbackFactory = OpenAPIFeignFallbackFactory.class)
public interface OpenAPIFeignService {

    @GetMapping("/openapi/actuator/info")
    String checkOpenAPIHealth();

}
