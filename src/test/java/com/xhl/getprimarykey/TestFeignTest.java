package com.xhl.getprimarykey;

import com.xhl.getprimarykey.feign.CRMFeignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootTest
@EnableFeignClients
public class TestFeignTest {

    @Autowired
    CRMFeignService testFeignService;

    @Test
    void contextLoads() {
        System.out.println("------"+testFeignService.checkCRMHealth());
    }

}
