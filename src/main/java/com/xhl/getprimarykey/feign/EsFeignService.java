package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "es",  fallbackFactory = ESFeignFallbackFactory.class)
public interface EsFeignService {

    //查询处置场列表
    @GetMapping("/es/actuator/info")
    String checkESHealth();

}
