package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "es2",  fallbackFactory = ES2FeignFallbackFactory.class)
public interface Es2FeignService {

    //查询处置场列表
    @GetMapping("/es2/actuator/info")
    String checkES2Health();

}
