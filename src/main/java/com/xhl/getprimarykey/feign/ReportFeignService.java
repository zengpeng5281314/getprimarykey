package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "report",  fallbackFactory = ReportFeignFallbackFactory.class)
public interface ReportFeignService {

    @GetMapping("/report/actuator/info")
    String checkReportHealth();

}
