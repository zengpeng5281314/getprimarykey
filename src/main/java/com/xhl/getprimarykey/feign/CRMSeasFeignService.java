package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "crm-seas",  fallbackFactory = CRMSeasFeignFallbackFactory.class)
public interface CRMSeasFeignService {

    @GetMapping("/crm-seas/status/health")
    String checkCrmSeasHealth();

}
