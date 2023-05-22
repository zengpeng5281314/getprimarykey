package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "marketing-site",  fallbackFactory = MarketingSiteFeignFallbackFactory.class)
public interface MarketingSiteFeignService {

    @GetMapping("/marketing-site/status/health")
    String checkMarketingSiteHealth();

}
