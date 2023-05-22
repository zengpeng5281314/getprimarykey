package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailEDMFeignFallbackFactory implements FallbackFactory<MailEDMFeignService> {

    @Override
    public MailEDMFeignService create(Throwable cause) {
        return new MailEDMFeignService() {
            @Override
            public String checkMailEDMHealth() {
                return "接口调用异常！";
            }
        };
    }
}
