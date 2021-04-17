package com.springdata.transactionManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.transactionManagement.entity.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
