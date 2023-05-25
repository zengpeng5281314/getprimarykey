package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DelayQueneFeignFallbackFactory implements FallbackFactory<DelayqueneFeignService> {

    @Override
    public DelayqueneFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new DelayqueneFeignService() {
            @Override
            public String checkDelayQueneHealth() {
                return "接口调用异常！";
            }
        };
    }
}
