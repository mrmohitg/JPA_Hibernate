package com.springdata.compositKey.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.compositKey.entity.Customers;
import com.springdata.compositKey.entity.CustomersId;

public interface CustomersRepository extends CrudRepository<Customers, CustomersId> {

}
