package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MinorFeignFallbackFactory implements FallbackFactory<MinorFeignService> {

    @Override
    public MinorFeignService create(Throwable cause) {
        return new MinorFeignService() {
            @Override
            public String checkMinorHealth() {
                return "接口调用异常！";
            }
        };
    }
}
