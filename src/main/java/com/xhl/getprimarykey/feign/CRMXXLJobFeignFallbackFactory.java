package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CRMXXLJobFeignFallbackFactory implements FallbackFactory<CRMXXLJobFeignService> {

    @Override
    public CRMXXLJobFeignService create(Throwable cause) {
        return new CRMXXLJobFeignService() {
            @Override
            public String checkCRMXXLjobHealth() {
                return "接口调用异常！";
            }
        };
    }
}
