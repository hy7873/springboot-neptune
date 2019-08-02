package com.hy.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghai
 * @Date:2019/7/11 14:48
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class ScheduleTask {

    public final static Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Scheduled(fixedRate = 5000)
    public void test1() {
        logger.info("currentTime - {}",System.currentTimeMillis());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test2() {
        logger.info("test2 - {}",System.currentTimeMillis());
    }

}
