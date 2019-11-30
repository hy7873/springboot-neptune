package com.hy.client;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;

/**
 * @Author: wanghai
 * @Date:2019/9/23 21:54
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class RocketClient {

    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    @Value("${mq.address}")
    private String nameAddr;


    @PostConstruct
    public void defaultMqProducer() {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(producerGroup);
        defaultMQProducer.setNamesrvAddr(nameAddr);
        defaultMQProducer.setVipChannelEnabled(false);
        try {
            defaultMQProducer.start();
            Message message = new Message("Test_topic","push","--- message send -----".getBytes());
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            for (int i = 0; i < 1; i++) {
                SendResult sendResult = defaultMQProducer.send(message);
                System.out.println("发送消息id：" + sendResult.getMsgId() + "发送状态：" + sendResult.getSendStatus());
            }
            stopWatch.stop();
            System.out.println("发送消息耗时：" + stopWatch.getTotalTimeMillis());
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }
}
