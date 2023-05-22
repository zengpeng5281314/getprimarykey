package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TimeLineFeignFallbackFactory implements FallbackFactory<TimeLineFeignService> {

    @Override
    public TimeLineFeignService create(Throwable cause) {
        return new TimeLineFeignService() {
            @Override
            public String checkTimeLineHealth() {
                return "接口调用异常！";
            }
        };
    }
}
