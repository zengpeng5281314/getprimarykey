package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "visitor-chat",  fallbackFactory = VisitorChatFeignFallbackFactory.class)
public interface VisitorChatFeignService {

    @GetMapping("/visitor-chat/actuator/info")
    String checkVisitorChatHealth();

}
