package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "crm-transfer",  fallbackFactory = CRMTransferFeignFallbackFactory.class)
public interface CRMTransferFeignService {

    //查询处置场列表
    @GetMapping("/crm-transfer/status/health")
    String checkCrmTransferHealth();

}
