package com.sky.taskdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author awl
 * @date 2023/9/18 22:35
 */
@Component
@Slf4j
public class MyTask {

    /**
     * 定时任务,每隔5秒,执行一次
     */
    //@Scheduled(cron="0/5 * * * * ? ")
    public void executeTask(){
        log.info("定时任务开始执行:{}",new Date());
    }
}
