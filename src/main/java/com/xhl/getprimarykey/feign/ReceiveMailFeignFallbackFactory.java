package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveMailFeignFallbackFactory implements FallbackFactory<ReceiveMailFeignService> {

    @Override
    public ReceiveMailFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new ReceiveMailFeignService() {
            @Override
            public String checkReceiveMailHealth() {
                return "接口调用异常！";
            }
        };
    }
}
