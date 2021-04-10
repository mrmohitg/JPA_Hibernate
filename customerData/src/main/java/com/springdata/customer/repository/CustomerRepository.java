package com.springdata.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdata.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	List<Customer> findByNameAndEmail(String name, String email);
	
	List<Customer> findByEmailLike(String email);
	
	List<Customer> findByIdIn(List<Integer> id);

}
