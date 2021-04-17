package com.springdata.transactionManagement;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.transactionManagement.service.BankAccountService;

@SpringBootTest
@RunWith(SpringRunner.class)
class TransactionManagementApplicationTests {

	@Autowired
	private BankAccountService bankAccountService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testTransfer() {
		bankAccountService.transfer(500);
	}

}
