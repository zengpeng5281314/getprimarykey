package com.xhl.getprimarykey.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "form-cust",  fallbackFactory = FormCustFeignFallbackFactory.class)
public interface FormCustFeignService {

    //查询处置场列表
    @GetMapping("/form-cust/actuator/info")
    String checkFormCustHealth();

}
