package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FileSysFeignFallbackFactory implements FallbackFactory<FileSysFeignService> {

    @Override
    public FileSysFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new FileSysFeignService() {
            @Override
            public String checkFileSysHealth() {
                return "接口调用异常！";
            }
        };
    }
}
