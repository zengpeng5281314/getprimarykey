package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChatGPTFeignFallbackFactory implements FallbackFactory<ChatGPTFeignService> {

    @Override
    public ChatGPTFeignService create(Throwable cause) {
        return new ChatGPTFeignService() {
            @Override
            public String checkChatGPTHealth() {
                return "接口调用异常！";
            }
        };
    }
}
