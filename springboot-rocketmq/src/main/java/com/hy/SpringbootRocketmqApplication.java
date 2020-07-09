package com.hy;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootRocketmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRocketmqApplication.class, args);
	}

	@Autowired
	private RocketMQTemplate rocketMQTemplate;

	@GetMapping("/testMq")
	public String testMq() {
		for (int i = 0; i <10 ; i++) {
			rocketMQTemplate.convertAndSend("test-topic","hello world"+i);
		}
		return "success";
	}

	@GetMapping("/testMqV2")
	public String testMqV2() {
		for (int i = 0; i <10 ; i++) {
			rocketMQTemplate.convertAndSend("test-topicV2","hello world"+i);
		}
		return "success";
	}

}
