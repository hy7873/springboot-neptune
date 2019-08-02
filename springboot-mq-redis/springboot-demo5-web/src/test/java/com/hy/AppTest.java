package com.hy;

import com.hy.cache.RedisClient;
import com.hy.mq.AmqpSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest
{

    @Autowired
    private AmqpSender amqpSender;

    @Autowired
    private RedisClient redisClient;

    @Test
    public void test() {
        amqpSender.sendMsg("testQueue","msg test");
    }

    @Test
    public void test1() {
        redisClient.put("aa","1111");
        System.out.println(redisClient.get("aa"));
    }
}
