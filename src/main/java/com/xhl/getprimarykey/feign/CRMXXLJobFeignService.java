package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "crm-xxljob",  fallbackFactory = CRMXXLJobFeignFallbackFactory.class)
public interface CRMXXLJobFeignService {

    //查询处置场列表
    @GetMapping("/crm/status/health")
    String checkCRMXXLjobHealth();

}
