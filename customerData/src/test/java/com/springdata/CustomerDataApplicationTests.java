package com.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.customer.entity.Customer;
import com.springdata.customer.repository.CustomerRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerDataApplicationTests {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer()
	{
		Customer customer = new Customer();
		customer.setName("Mohit");
		customer.setEmail("mohit.gmail.com");
		customerRepository.save(customer);
	}
	
}
