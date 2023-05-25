package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "app-push",  fallbackFactory = AppPushFeignFallbackFactory.class)
public interface AppPushFeignService {

    @GetMapping("/app-push/status/health")
    String checkAppPushHealth();

}
