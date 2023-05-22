package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailXXLJOBFeignFallbackFactory implements FallbackFactory<MailXXLJOBFeignService> {

    @Override
    public MailXXLJOBFeignService create(Throwable cause) {
        return new MailXXLJOBFeignService() {
            @Override
            public String checkMailXXLJOBHealth() {
                return "接口调用异常！";
            }
        };
    }
}
