package com.springdata.compositKey;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.compositKey.entity.Customers;
import com.springdata.compositKey.repository.CustomersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CompositKeyApplicationTests {
	
	@Autowired
	private CustomersRepository customersRepository; 

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSavecustomers() {
		Customers customers = new Customers();
		customers.setId(123);
		customers.setEmail("test@test.com");
		customers.setName("Test");
		customersRepository.save(customers);
	}

}
