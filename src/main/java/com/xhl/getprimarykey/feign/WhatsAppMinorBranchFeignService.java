package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "whatsappMinorBranch",  fallbackFactory = WhatsAppMinorBranchFeignFallbackFactory.class)
public interface WhatsAppMinorBranchFeignService {

    @GetMapping("/whatsappMinorBranch/status/health")
    String checkWhatsAppMinorBranchHealth();

}
