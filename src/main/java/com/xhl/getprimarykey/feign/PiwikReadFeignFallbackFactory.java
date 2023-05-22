package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PiwikReadFeignFallbackFactory implements FallbackFactory<PiwikReadFeignService> {

    @Override
    public PiwikReadFeignService create(Throwable cause) {
        return new PiwikReadFeignService() {
            @Override
            public String checkPiwikReadHealth() {
                return "接口调用异常！";
            }
        };
    }
}
