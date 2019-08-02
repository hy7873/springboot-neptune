package com.hy.service;

import com.hy.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.Future;

/**
 * @Author: wanghai
 * @Date:2019/7/23 20:28
 * @Copyright:reach-life
 * @Description:
 */
@Service
public class GitHubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Async
    public Future<User> findUser(String user) throws InterruptedException {
        logger.info(Thread.currentThread().getName() + " Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(5000L);
        return new AsyncResult<>(results);
    }

    public User findUserV2(String user) {
        logger.info(Thread.currentThread().getName() + " Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        return results;
    }

}
