package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class AppPushFeignFallbackFactory implements FallbackFactory<AppPushFeignService> {

    @Override
    public AppPushFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new AppPushFeignService() {
            @Override
            public String checkAppPushHealth() {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String remoteAddr = request.getRemoteAddr();
                log.info("checkAppPushHealth Request IP Address: " + remoteAddr);
                return "接口调用异常！";
            }
        };
    }
}
