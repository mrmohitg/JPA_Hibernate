package com.springdata.mongoDemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.mongoDemo.model.Product;
import com.springdata.mongoDemo.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongoDemoApplicationTests {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testSave() {
		Product product = new Product();
		product.setId("1");
		product.setName("Mac Operating System");
		product.setPrice(2000f);
		productRepository.save(product);
	}

}
