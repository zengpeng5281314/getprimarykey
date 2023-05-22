package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InstagramFeignFallbackFactory implements FallbackFactory<InstagramFeignService> {

    @Override
    public InstagramFeignService create(Throwable cause) {
        return new InstagramFeignService() {
            @Override
            public String checkInstagramHealth() {
                return "接口调用异常！";
            }
        };
    }
}
