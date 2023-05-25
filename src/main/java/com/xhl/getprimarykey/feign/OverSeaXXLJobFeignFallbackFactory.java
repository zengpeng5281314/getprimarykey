package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OverSeaXXLJobFeignFallbackFactory implements FallbackFactory<OverSeaXXLJobFeignService> {

    @Override
    public OverSeaXXLJobFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new OverSeaXXLJobFeignService() {
            @Override
            public String checkOverSeaXXLJobHealth() {
                return "接口调用异常！";
            }
        };
    }
}
