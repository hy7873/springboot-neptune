package com.hy.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "test-groupV2", topic = "test-topicV2")
public class TestRocketMQListenerV2 implements RocketMQListener<String> {



    @Override
    public void onMessage(String  message) {
        log.info("FwReceiverV2=>{}", message);
    }

}