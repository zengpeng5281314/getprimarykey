package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DashboardFeignFallbackFactory implements FallbackFactory<DashboardFeignService> {

    @Override
    public DashboardFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new DashboardFeignService() {
            @Override
            public String checkDashboardHealth() {
                return "接口调用异常！";
            }
        };
    }
}
