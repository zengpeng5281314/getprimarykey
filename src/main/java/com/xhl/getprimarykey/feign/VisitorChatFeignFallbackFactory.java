package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VisitorChatFeignFallbackFactory implements FallbackFactory<VisitorChatFeignService> {

    @Override
    public VisitorChatFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new VisitorChatFeignService() {
            @Override
            public String checkVisitorChatHealth() {
                return "接口调用异常！";
            }
        };
    }
}
