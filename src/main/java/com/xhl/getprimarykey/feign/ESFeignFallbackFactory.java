package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ESFeignFallbackFactory implements FallbackFactory<EsFeignService> {

    @Override
    public EsFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new EsFeignService() {
            @Override
            public String checkESHealth() {
                return "接口调用异常！";
            }
        };
    }
}
