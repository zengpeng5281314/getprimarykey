package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "delayquene",  fallbackFactory = DelayQueneFeignFallbackFactory.class)
public interface DelayqueneFeignService {

    //查询处置场列表
    @GetMapping("/delayquene/actuator/info")
    String checkDelayQueneHealth();

}
