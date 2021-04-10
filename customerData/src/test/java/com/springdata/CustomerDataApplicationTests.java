package com.springdata;

import java.util.Arrays;
import java.util.List;

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
		customer.setName("Priya");
		customer.setEmail("priya.yahoomail.com");
		customerRepository.save(customer);
	}
	
	@Test
	public void testFindByNameAndEmail()
	{
		List<Customer> listOfCusomer = customerRepository.findByNameAndEmail("Mohit","mohit.gmail.com");
		listOfCusomer.forEach(C -> System.out.println(C.getName()+" "+C.getEmail()));
	}
	
	@Test
	public void testFindByEmailLike()
	{
		List<Customer> listOfCusomer = customerRepository.findByEmailLike("%gmail%");
		listOfCusomer.forEach(C -> System.out.println(C.getName()+" "+C.getEmail()));
	}
	
	@Test
	public void testFindByIdIn()
	{
		List<Customer> listOfCusomer = customerRepository.findByIdIn(Arrays.asList(1,2,3,4));
		listOfCusomer.forEach(C -> System.out.println(C.getName()+" "+C.getEmail()));
	}
	
}
