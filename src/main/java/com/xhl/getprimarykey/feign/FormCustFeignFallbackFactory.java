package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class FormCustFeignFallbackFactory implements FallbackFactory<FormCustFeignService> {

    @Override
    public FormCustFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new FormCustFeignService() {
            @Override
            public String checkFormCustHealth() {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String remoteAddr = request.getRemoteAddr();
                log.info("checkFormCustHealth Request IP Address: " + remoteAddr);
                return "接口调用异常！";
            }
        };
    }
}
