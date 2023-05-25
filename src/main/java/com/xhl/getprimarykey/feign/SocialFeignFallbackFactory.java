package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SocialFeignFallbackFactory implements FallbackFactory<SocialFeignService> {

    @Override
    public SocialFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new SocialFeignService() {
            @Override
            public String checkSocialHealth() {
                return "接口调用异常！";
            }
        };
    }
}
