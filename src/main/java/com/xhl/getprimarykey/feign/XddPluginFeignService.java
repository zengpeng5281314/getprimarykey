package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "xdd-plugin",  fallbackFactory = XddPluginFeignFallbackFactory.class)
public interface XddPluginFeignService {

    @GetMapping("/xdd-plugin/status/health")
    String checkXddPluginHealth();

}
