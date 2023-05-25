package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EDMWebFeignFallbackFactory implements FallbackFactory<EDMWebFeignService> {

    @Override
    public EDMWebFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new EDMWebFeignService() {
            @Override
            public String checkEdmWebHealth() {
                return "接口调用异常！";
            }
        };
    }
}
