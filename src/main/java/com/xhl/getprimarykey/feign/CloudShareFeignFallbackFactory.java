package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CloudShareFeignFallbackFactory implements FallbackFactory<CloudShareFeignService> {

    @Override
    public CloudShareFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new CloudShareFeignService() {
            @Override
            public String checkCloudShareHealth() {
                return "接口调用异常！";
            }
        };
    }
}
