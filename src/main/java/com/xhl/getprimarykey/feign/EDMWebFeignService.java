package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "edm-web",  fallbackFactory = EDMWebFeignFallbackFactory.class)
public interface EDMWebFeignService {

    //查询处置场列表
    @GetMapping("/edm-web/actuator/info")
    String checkEdmWebHealth();

}
