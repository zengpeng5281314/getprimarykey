package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "new-privilege",  fallbackFactory = NewPrivilegeFeignFallbackFactory.class)
public interface NewPrivilegeFeignService {

    @GetMapping("/new-privilege/actuator/info")
    String checkNewPrivilegeHealth();

}
