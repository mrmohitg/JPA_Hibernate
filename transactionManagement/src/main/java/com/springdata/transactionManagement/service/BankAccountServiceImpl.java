package com.springdata.transactionManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.transactionManagement.entity.BankAccount;
import com.springdata.transactionManagement.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public void transfer(int amount) {
		
		Optional<BankAccount> bankAccount = bankAccountRepository.findById(1); 
		BankAccount obamaBankAccount = bankAccount.get();
		obamaBankAccount.setBalance(obamaBankAccount.getBalance()-amount);
		bankAccountRepository.save(obamaBankAccount);
		
		Optional<BankAccount> bankAccount1 = bankAccountRepository.findById(2); 
		BankAccount trumpBankAccount = bankAccount1.get();
		trumpBankAccount.setBalance(trumpBankAccount.getBalance()+amount);
		bankAccountRepository.save(trumpBankAccount);

	}

}
