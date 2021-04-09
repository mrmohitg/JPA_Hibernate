package com.springdata;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.product.entity.Product;
import com.springdata.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductDataApplicationTests {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate()
	{
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("Awesome");
		product.setPrice(1000d);
		productRepository.save(product);
	}

}
