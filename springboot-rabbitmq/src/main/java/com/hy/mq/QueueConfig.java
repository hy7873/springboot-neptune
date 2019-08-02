package com.hy.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wanghai
 * @Date:2019/7/4 9:50
 * @Copyright:reach-life
 * @Description:
 */
@Configuration
public class QueueConfig {

    public final static String TestQueue1 = "test1Queue";

    public final static String TestQueue2 = "test2Queue";

    @Bean
    public Queue test1Queue() {
        return new Queue(QueueConfig.TestQueue1,true,false,false);
    }


    @Bean
    public Queue test2Queue() {
        return new Queue(QueueConfig.TestQueue2,true,false,false);
    }

}
