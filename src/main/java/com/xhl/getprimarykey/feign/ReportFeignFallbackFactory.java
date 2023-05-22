package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReportFeignFallbackFactory implements FallbackFactory<ReportFeignService> {

    @Override
    public ReportFeignService create(Throwable cause) {
        return new ReportFeignService() {
            @Override
            public String checkReportHealth() {
                return "接口调用异常！";
            }
        };
    }
}
