package com.springdata.hibernateInheritance;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.hibernateInheritance.entity.Check;
import com.springdata.hibernateInheritance.entity.CreditCard;
import com.springdata.hibernateInheritance.repository.PaymentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class HibernateInheritanceApplicationTests {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void createPayment() {

		CreditCard creditCard = new CreditCard();
		creditCard.setId(1);
		creditCard.setAmount(123);
		creditCard.setCardNumber("1234567891");
		paymentRepository.save(creditCard);

		Check check = new Check();
		check.setId(2);
		check.setAmount(123);
		check.setCheckNumber("9876543210");
		paymentRepository.save(check);
	}

}
