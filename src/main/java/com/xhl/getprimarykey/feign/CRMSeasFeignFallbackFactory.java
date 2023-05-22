package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CRMSeasFeignFallbackFactory implements FallbackFactory<CRMSeasFeignService> {

    @Override
    public CRMSeasFeignService create(Throwable cause) {
        return new CRMSeasFeignService() {
            @Override
            public String checkCrmSeasHealth() {
                return "接口调用异常！";
            }
        };
    }
}
