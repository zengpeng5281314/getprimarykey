package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MarketingSiteFeignFallbackFactory implements FallbackFactory<MarketingSiteFeignService> {

    @Override
    public MarketingSiteFeignService create(Throwable cause) {
        return new MarketingSiteFeignService() {
            @Override
            public String checkMarketingSiteHealth() {
                return "接口调用异常！";
            }
        };
    }
}
