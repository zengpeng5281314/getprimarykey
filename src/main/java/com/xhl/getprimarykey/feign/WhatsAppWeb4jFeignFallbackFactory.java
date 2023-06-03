package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class WhatsAppWeb4jFeignFallbackFactory implements FallbackFactory<WhatsAppWeb4jFeignService> {

    @Override
    public WhatsAppWeb4jFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new WhatsAppWeb4jFeignService() {
            @Override
            public String checkWhatsAppWeb4jHealth() {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String remoteAddr = request.getRemoteAddr();
                log.info("checkWhatsAppWeb4jHealth Request IP Address: " + remoteAddr);
                return "接口调用异常！";
            }
        };
    }
}
