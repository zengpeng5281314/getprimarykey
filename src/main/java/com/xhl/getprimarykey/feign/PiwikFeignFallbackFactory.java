package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PiwikFeignFallbackFactory implements FallbackFactory<PiwikFeignService> {

    @Override
    public PiwikFeignService create(Throwable cause) {
        return new PiwikFeignService() {
            @Override
            public String checkPiwikhHealth() {
                return "接口调用异常！";
            }
        };
    }
}
