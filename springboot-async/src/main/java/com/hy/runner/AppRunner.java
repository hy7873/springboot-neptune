package com.hy.runner;

import com.hy.model.User;
import com.hy.service.GitHubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @Author: wanghai
 * @Date:2019/7/23 20:37
 * @Copyright:reach-life
 * @Description:
 */
@Component
public class AppRunner implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @Override
    public void run(String... strings) throws Exception {
        long start = System.currentTimeMillis();
        Future<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        Future<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        Future<User> page3 = gitHubLookupService.findUser("Spring-Projects");
        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(1000*5); //10-millisecond pause between each check
        }
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());

        User user1 = gitHubLookupService.findUserV2("PivotalSoftware");
        User user2 = gitHubLookupService.findUserV2("CloudFoundry");
        User user3 = gitHubLookupService.findUserV2("Spring-Projects");
        logger.info("--> " + user1);
        logger.info("--> " + user2);
        logger.info("--> " + user3);
    }
}
