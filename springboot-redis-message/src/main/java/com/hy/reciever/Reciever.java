package com.hy.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: wanghai
 * @Date:2019/7/2 9:36
 * @Copyright:reach-life
 * @Description:
 */
public class Reciever {

    private static final Logger logger = LoggerFactory.getLogger(Reciever.class);

    public void recieveMessage(String message) {
        logger.info("recieved message : {}",message);
    }

}
