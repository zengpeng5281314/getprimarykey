package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppPushFeignFallbackFactory implements FallbackFactory<AppPushFeignService> {

    @Override
    public AppPushFeignService create(Throwable cause) {
        return new AppPushFeignService() {
            @Override
            public String checkAppPushHealth() {
                return "接口调用异常！";
            }
        };
    }
}
