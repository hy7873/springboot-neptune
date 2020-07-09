package com.hy;

import com.hy.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private RedisDao redisDao;

	private static Logger logger = LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

	@Test
	public void contextLoads() {

		for (int i = 0; i < 100; i++) {
			redisDao.setCache("name" + i,"wanghai",2L);

			String name = redisDao.getCache("name" + i);

			System.out.println("name = " + name);

			logger.info("name = {}",name);
		}

	}

	@Test
	public void test1() {
		long id = redisDao.incrBy("test1243",1);
		System.out.println(id);
	}

}
