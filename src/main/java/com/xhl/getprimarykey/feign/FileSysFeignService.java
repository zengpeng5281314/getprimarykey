package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "file-sys",  fallbackFactory = FileSysFeignFallbackFactory.class)
public interface FileSysFeignService {

    @GetMapping("/file-sys/actuator/info")
    String checkFileSysHealth();

}
