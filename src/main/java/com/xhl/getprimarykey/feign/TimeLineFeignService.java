package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "timeline",  fallbackFactory = TimeLineFeignFallbackFactory.class)
public interface TimeLineFeignService {

    @GetMapping("/timeline/status/health")
    String checkTimeLineHealth();

}
