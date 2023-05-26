package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "center",  fallbackFactory = AppPushFeignFallbackFactory.class)
public interface TestFeignService {

    @PostMapping("/centerapi/api/test")
    String checkAppPushHealth();

}
