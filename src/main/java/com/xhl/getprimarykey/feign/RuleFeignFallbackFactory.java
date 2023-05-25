package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RuleFeignFallbackFactory implements FallbackFactory<RuleFeignService> {

    @Override
    public RuleFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new RuleFeignService() {
            @Override
            public String checkRuleHealth() {
                return "接口调用异常！";
            }
        };
    }
}
