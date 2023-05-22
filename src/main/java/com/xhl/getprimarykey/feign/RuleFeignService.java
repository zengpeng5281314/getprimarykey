package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "rule",  fallbackFactory = RuleFeignFallbackFactory.class)
public interface RuleFeignService {

    @GetMapping("/rule/actuator/info")
    String checkRuleHealth();

}
