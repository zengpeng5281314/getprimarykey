package com.xhl.getprimarykey.feign;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NewPrivilegeFeignFallbackFactory implements FallbackFactory<NewPrivilegeFeignService> {

    @Override
    public NewPrivilegeFeignService create(Throwable cause) {
        cause.printStackTrace();
        return new NewPrivilegeFeignService() {
            @Override
            public String checkNewPrivilegeHealth() {
                return "接口调用异常！";
            }
        };
    }
}
