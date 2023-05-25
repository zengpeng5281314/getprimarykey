package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OverSeaFeignFallbackFactory implements FallbackFactory<OverSeaFeignService> {

    @Override
    public OverSeaFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new OverSeaFeignService() {
            @Override
            public String checkOverseaHealth() {
                return "接口调用异常！";
            }
        };
    }
}
