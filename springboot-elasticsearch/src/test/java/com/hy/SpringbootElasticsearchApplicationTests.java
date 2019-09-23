package com.hy;

import com.hy.dao.UserEventDao;
import com.hy.model.UserEvent;
import com.hy.service.UserEventServiceImpl;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

	@Autowired
	private UserEventServiceImpl userEventService;


	@Test
	public void contextLoads() {
	}


	@Test
	public void testDao() {
		UserEvent userEvent = new UserEvent();
		userEvent.setId(1L);
		userEvent.setUserId("1000");
		userEvent.setDeviceId("xxxxx");
		userEvent.setDate(new Date());
		userEvent.setAction("cccc");
		userEventService.save(userEvent);
	}
}
