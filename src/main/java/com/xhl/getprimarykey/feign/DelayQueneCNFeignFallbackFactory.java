package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DelayQueneCNFeignFallbackFactory implements FallbackFactory<DelayQueneCNFeignService> {

    @Override
    public DelayQueneCNFeignService create(Throwable cause) {
        return new DelayQueneCNFeignService() {
            @Override
            public String checkDelayQueneCNHealth() {
                return "接口调用异常！";
            }
        };
    }
}
