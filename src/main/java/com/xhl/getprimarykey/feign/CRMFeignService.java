package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "crm",  fallbackFactory = CRMFeignFallbackFactory.class)
public interface CRMFeignService {

    //查询处置场列表
    @GetMapping("/crm/status/health")
    String checkCRMHealth();

}
