package com.xhl.getprimarykey;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableConfigurationProperties
@EnableLeafServer
public class GetprimarykeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetprimarykeyApplication.class, args);
    }

    @GetMapping("/status/health")
    public int healthCheck(){
        return 1;
    }
}
