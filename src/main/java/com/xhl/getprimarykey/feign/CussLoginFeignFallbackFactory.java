package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CussLoginFeignFallbackFactory implements FallbackFactory<CussLoginFeignService> {

    @Override
    public CussLoginFeignService create(Throwable cause) {
        return new CussLoginFeignService() {
            @Override
            public String checkCussLoginHealth() {
                return "接口调用异常！";
            }
        };
    }
}
