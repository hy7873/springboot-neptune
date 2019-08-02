package com.hy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootRestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestTemplateApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(SpringbootRestTemplateApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
		return args -> {
			String ret = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random",String.class);
			logger.info("ret = {}",ret);
		};
	}

}
