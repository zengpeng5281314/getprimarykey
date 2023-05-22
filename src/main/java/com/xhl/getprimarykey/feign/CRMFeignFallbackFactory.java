package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CRMFeignFallbackFactory implements FallbackFactory<CRMFeignService> {

    @Override
    public CRMFeignService create(Throwable cause) {
        return new CRMFeignService() {
            @Override
            public String checkCRMHealth() {
                return "接口调用异常！";
            }
        };
    }
}
