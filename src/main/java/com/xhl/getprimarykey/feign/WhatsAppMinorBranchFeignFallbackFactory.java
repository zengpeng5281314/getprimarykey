package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WhatsAppMinorBranchFeignFallbackFactory implements FallbackFactory<WhatsAppMinorBranchFeignService> {

    @Override
    public WhatsAppMinorBranchFeignService create(Throwable cause) {
        return new WhatsAppMinorBranchFeignService() {
            @Override
            public String checkWhatsAppMinorBranchHealth() {
                return "接口调用异常！";
            }
        };
    }
}
