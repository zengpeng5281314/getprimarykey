package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "crawler",  fallbackFactory = CrawlerFeignFallbackFactory.class)
public interface CrawlerFeignService {

    //查询处置场列表
    @GetMapping("/crawler/status/health")
    String checkCrawlerHealth();

}
