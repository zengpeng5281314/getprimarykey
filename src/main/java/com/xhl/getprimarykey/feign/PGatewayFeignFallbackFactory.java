package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PGatewayFeignFallbackFactory implements FallbackFactory<PGatewayFeignService> {

    @Override
    public PGatewayFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new PGatewayFeignService() {
            @Override
            public String checkPGatewayHealth() {
                return "接口调用异常！";
            }
        };
    }
}
