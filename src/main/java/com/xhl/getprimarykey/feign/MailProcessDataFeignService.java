package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mail-process-data",  fallbackFactory = MailProcessDataFeignFallbackFactory.class)
public interface MailProcessDataFeignService {

    @GetMapping("/mail_process/status/health")
    String checkMailProcessHealth();

}
