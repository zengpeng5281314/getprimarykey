package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailHKFeignFallbackFactory implements FallbackFactory<MailHKFeignService> {

    @Override
    public MailHKFeignService create(Throwable cause) {
        return new MailHKFeignService() {
            @Override
            public String checkMailHKHealth() {
                return "接口调用异常！";
            }
        };
    }
}
