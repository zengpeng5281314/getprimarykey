package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TranslationFeignFallbackFactory implements FallbackFactory<TranslationFeignService> {

    @Override
    public TranslationFeignService create(Throwable cause) {
        return new TranslationFeignService() {
            @Override
            public String checkTranslationHealth() {
                return "接口调用异常！";
            }
        };
    }
}
