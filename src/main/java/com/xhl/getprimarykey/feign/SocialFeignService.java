package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "social",  fallbackFactory = SocialFeignFallbackFactory.class)
public interface SocialFeignService {

    @GetMapping("/social/status/health")
    String checkSocialHealth();

}
