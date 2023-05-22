package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WhatsAppFeignFallbackFactory implements FallbackFactory<WhatsAppFeignService> {

    @Override
    public WhatsAppFeignService create(Throwable cause) {
        return new WhatsAppFeignService() {
            @Override
            public String checkWhatsAppHealth() {
                return "接口调用异常！";
            }
        };
    }
}
