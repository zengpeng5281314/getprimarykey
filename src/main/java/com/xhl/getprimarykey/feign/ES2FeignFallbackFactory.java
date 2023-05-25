package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ES2FeignFallbackFactory implements FallbackFactory<Es2FeignService> {

    @Override
    public Es2FeignService create(Throwable cause) {
        cause.printStackTrace();
        return new Es2FeignService() {
            @Override
            public String checkES2Health() {
                return "接口调用异常！";
            }
        };
    }
}
