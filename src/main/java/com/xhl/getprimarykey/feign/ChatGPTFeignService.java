package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "chatgpt",  fallbackFactory = ChatGPTFeignFallbackFactory.class)
public interface ChatGPTFeignService {

    @GetMapping("/chatgpt/status/health")
    String checkChatGPTHealth();

}
