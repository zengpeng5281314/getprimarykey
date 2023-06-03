package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class CussLoginFeignFallbackFactory implements FallbackFactory<CussLoginFeignService> {

    @Override
    public CussLoginFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new CussLoginFeignService() {
            @Override
            public String checkCussLoginHealth() {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String remoteAddr = request.getRemoteAddr();
                log.info("checkCussLoginHealth Request IP Address: " + remoteAddr);
                return "接口调用异常！";
            }
        };
    }
}
