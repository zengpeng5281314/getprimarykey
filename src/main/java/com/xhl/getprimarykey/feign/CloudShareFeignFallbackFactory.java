package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class CloudShareFeignFallbackFactory implements FallbackFactory<CloudShareFeignService> {

    @Override
    public CloudShareFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new CloudShareFeignService() {
            @Override
            public String checkCloudShareHealth() {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String remoteAddr = request.getRemoteAddr();
                log.info("checkCloudShareHealth Request IP Address: " + remoteAddr);
                return "接口调用异常！";
            }
        };
    }
}
