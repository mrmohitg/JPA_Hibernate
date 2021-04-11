package com.springdata.hibernateInheritance.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.hibernateInheritance.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
