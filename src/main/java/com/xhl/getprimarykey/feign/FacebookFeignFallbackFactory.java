package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FacebookFeignFallbackFactory implements FallbackFactory<FacebookFeignService> {

    @Override
    public FacebookFeignService create(Throwable cause) {
        return new FacebookFeignService() {
            @Override
            public String checkFaceBookHealth() {
                return "接口调用异常！";
            }
        };
    }
}
