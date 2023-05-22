package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class XddPluginFeignFallbackFactory implements FallbackFactory<XddPluginFeignService> {

    @Override
    public XddPluginFeignService create(Throwable cause) {
        return new XddPluginFeignService() {
            @Override
            public String checkXddPluginHealth() {
                return "接口调用异常！";
            }
        };
    }
}
