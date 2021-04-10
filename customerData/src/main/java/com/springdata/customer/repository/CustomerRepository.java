package com.springdata.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
