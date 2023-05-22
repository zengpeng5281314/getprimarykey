package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CrawlerFeignFallbackFactory implements FallbackFactory<CrawlerFeignService> {

    @Override
    public CrawlerFeignService create(Throwable cause) {
        return new CrawlerFeignService() {
            @Override
            public String checkCrawlerHealth() {
                return "接口调用异常！";
            }
        };
    }
}
