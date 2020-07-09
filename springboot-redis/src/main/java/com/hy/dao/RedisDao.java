package com.hy.dao;

import com.hy.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


    public Long incrBy(String key,int incr) {
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        String value = valueOperations.get(key);
        long expire = stringRedisTemplate.getExpire(key);
        if (StringUtils.isEmpty(value)) {
            long time = DateUtils.getTodayLast().getTime() - System.currentTimeMillis();
            valueOperations.set(key,"0",time,TimeUnit.MILLISECONDS);
        }
        return valueOperations.increment(key,incr);
    }


}
