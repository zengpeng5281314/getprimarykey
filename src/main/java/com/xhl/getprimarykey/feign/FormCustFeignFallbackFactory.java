package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FormCustFeignFallbackFactory implements FallbackFactory<FormCustFeignService> {

    @Override
    public FormCustFeignService create(Throwable cause) {
        return new FormCustFeignService() {
            @Override
            public String checkFormCustHealth() {
                return "接口调用异常！";
            }
        };
    }
}
