package com.hy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SpringbootRedisMessageApplication {

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext applicationContext = SpringApplication.run(SpringbootRedisMessageApplication.class, args);
		StringRedisTemplate stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
		stringRedisTemplate.convertAndSend("chat","aaaa111222");
	}


}
