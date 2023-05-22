package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "whatsappweb4j",  fallbackFactory = WhatsAppWeb4jFeignFallbackFactory.class)
public interface WhatsAppWeb4jFeignService {

    @GetMapping("/status/health")
    String checkWhatsAppWeb4jHealth();

}
