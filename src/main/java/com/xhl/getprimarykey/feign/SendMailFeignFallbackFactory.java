package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendMailFeignFallbackFactory implements FallbackFactory<SendMailFeignService> {

    @Override
    public SendMailFeignService create(Throwable cause) {
        return new SendMailFeignService() {
            @Override
            public String checkSendMailHealth() {
                return "接口调用异常！";
            }
        };
    }
}
