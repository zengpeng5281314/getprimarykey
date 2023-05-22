package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WhatsAppWeb4jFeignFallbackFactory implements FallbackFactory<WhatsAppWeb4jFeignService> {

    @Override
    public WhatsAppWeb4jFeignService create(Throwable cause) {
        return new WhatsAppWeb4jFeignService() {
            @Override
            public String checkWhatsAppWeb4jHealth() {
                return "接口调用异常！";
            }
        };
    }
}
