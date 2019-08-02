package com.hy.mq.listener;

import com.hy.mq.AmqpSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wanghai on 2018/9/24.
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "testQueue"))
public class TestListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmqpSender.class);

    @RabbitHandler
    public void testListener(String msg) {
        LOGGER.info("TestListener :{}",msg);
    }

}
