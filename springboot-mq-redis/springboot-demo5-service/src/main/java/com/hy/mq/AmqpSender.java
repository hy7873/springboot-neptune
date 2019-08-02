package com.hy.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wanghai on 2018/9/24.
 */

@Component
public class AmqpSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmqpSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public boolean sendMsg(String queueName,String msg) {
        amqpTemplate.convertAndSend(queueName,msg);
        LOGGER.info("AmqpSender send queue:{},msg:{}",queueName,msg);
        return true;
    }

}
