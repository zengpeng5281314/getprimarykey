package com.xhl.getprimarykey;

import com.xhl.getprimarykey.feign.CRMFeignService;
import com.xhl.getprimarykey.feign.TestFeignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootTest
@EnableFeignClients
public class TestFeignTest {

    @Autowired
    CRMFeignService crmFeignService;
    @Autowired
    TestFeignService testFeignService;

    @Test
    void contextLoads() {
        System.out.println("------"+crmFeignService.checkCRMHealth());
    }

    @Test
    void checkAppPushHealth() {
        System.out.println("------"+testFeignService.checkAppPushHealth());
    }
}
