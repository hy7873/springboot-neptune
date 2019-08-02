package com.hy.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghai
 * @Date:2019/7/4 9:30
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class Reciever {

    private static final Logger logger = LoggerFactory.getLogger(Reciever.class);

    @RabbitListener(queues = QueueConfig.TestQueue1)
    public void onMessageTest1Queue(String message) {
        logger.info("onMessageTest1Queue recieved : {}",message);
    }

}
