package com.hy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wanghai
 * @Date:2019/6/22 23:40
 * @Copyright:reach-life
 * @Description:
 */

@Repository
public class RedisDao {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void setCache(String key,String value,long time) {
        stringRedisTemplate.boundValueOps(key).set(value,time,TimeUnit.MINUTES);
    }


    public String getCache(String key) {
        return stringRedisTemplate.boundValueOps(key).get();
    }
}
