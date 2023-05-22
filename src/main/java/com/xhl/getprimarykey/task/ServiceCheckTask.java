package com.xhl.getprimarykey.task;

import com.xhl.getprimarykey.conf.RedisUtil;
import com.xhl.getprimarykey.service.ICheckHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ServiceCheckTask {

    @Autowired
    ICheckHealthService checkHealthService;
    @Autowired
    RedisUtil redisUtil;
    @Value("service.check")
    private boolean serviceCheck;


    // 添加定时任务 cron表达式：每2分钟执行一次
    @Scheduled(cron = "0 0/1 * * * ?")
    public void checkAllService() {
        if (!serviceCheck)
            return;
        if (redisUtil.setIfAbsentOutTime("checkAllService", "1", 10, TimeUnit.SECONDS))
            checkHealthService.checkAllService();
    }

}
