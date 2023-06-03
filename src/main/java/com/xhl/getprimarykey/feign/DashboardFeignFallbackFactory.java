package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class DashboardFeignFallbackFactory implements FallbackFactory<DashboardFeignService> {

    @Override
    public DashboardFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new DashboardFeignService() {
            @Override
            public String checkDashboardHealth() {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String remoteAddr = request.getRemoteAddr();
                log.info("checkDashboardHealth Request IP Address: " + remoteAddr);
                return "接口调用异常！";
            }
        };
    }
}
