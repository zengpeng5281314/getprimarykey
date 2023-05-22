package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "whatsapp",  fallbackFactory = WhatsAppFeignFallbackFactory.class)
public interface WhatsAppFeignService {

    @GetMapping("/whatsapp/status/health")
    String checkWhatsAppHealth();

}
