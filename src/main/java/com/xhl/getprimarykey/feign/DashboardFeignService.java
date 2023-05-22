package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dashboard",  fallbackFactory = DashboardFeignFallbackFactory.class)
public interface DashboardFeignService {

    @GetMapping("/dashboard/status/health")
    String checkDashboardHealth();

}
