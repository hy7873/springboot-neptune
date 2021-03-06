package com.hy;

import com.hy.mq.QueueConfig;
import com.hy.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() {
		sender.sendMsg(QueueConfig.TestQueue1,"ssssss");
	}

}
