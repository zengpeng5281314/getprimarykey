package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailFeignFallbackFactory implements FallbackFactory<MailFeignService> {

    @Override
    public MailFeignService create(Throwable cause) {
        return new MailFeignService() {
            @Override
            public String checkMailHealth() {
                return "接口调用异常！";
            }
        };
    }
}
