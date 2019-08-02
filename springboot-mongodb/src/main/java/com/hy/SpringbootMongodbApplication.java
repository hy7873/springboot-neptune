package com.hy;

import com.hy.dao.CustomerRepository;
import com.hy.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMongodbApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		customerRepository.deleteAll();

		customerRepository.save(new Customer(1,"11","1111"));
		customerRepository.save(new Customer(2,"22","2222"));

		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}


	}
}
