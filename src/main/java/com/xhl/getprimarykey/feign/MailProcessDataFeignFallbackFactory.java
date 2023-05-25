package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailProcessDataFeignFallbackFactory implements FallbackFactory<MailProcessDataFeignService> {

    @Override
    public MailProcessDataFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new MailProcessDataFeignService() {
            @Override
            public String checkMailProcessHealth() {
                return "接口调用异常！";
            }
        };
    }
}
