package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "facebook",  fallbackFactory = FacebookFeignFallbackFactory.class)
public interface FacebookFeignService {

    //查询处置场列表
    @GetMapping("/facebook/status/health")
    String checkFaceBookHealth();

}
