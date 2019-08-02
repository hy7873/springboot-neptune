package com.hy.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wanghai
 * @Date:2019/7/4 9:58
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String queueName,String msg) {
        rabbitTemplate.convertAndSend(queueName,msg);
    }

}
