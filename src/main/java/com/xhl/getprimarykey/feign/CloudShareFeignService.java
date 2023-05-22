package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloudshare",  fallbackFactory = CloudShareFeignFallbackFactory.class)
public interface CloudShareFeignService {

    //查询处置场列表
    @GetMapping("/cloudshare/status/health")
    String checkCloudShareHealth();

}
