package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "translation",  fallbackFactory = TranslationFeignFallbackFactory.class)
public interface TranslationFeignService {


    @GetMapping("/translation/actuator/info")
    String checkTranslationHealth();

}
