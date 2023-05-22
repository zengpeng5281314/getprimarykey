package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CRMTransferFeignFallbackFactory implements FallbackFactory<CRMTransferFeignService> {

    @Override
    public CRMTransferFeignService create(Throwable cause) {
        return new CRMTransferFeignService() {
            @Override
            public String checkCrmTransferHealth() {
                return "接口调用异常！";
            }
        };
    }
}
