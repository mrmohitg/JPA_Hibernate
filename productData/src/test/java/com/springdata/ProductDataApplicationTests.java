package com.springdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

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
	
	@Test
	public void testRead()
	{
		Product product = productRepository.findById(1).get();
		assertNotNull(product);
		assertEquals("IPhone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> "+product.getDesc());
	}
	
	@Test
	public void testUpdate()
	{
		Product product = productRepository.findById(1).get();
		product.setName("IPad");
		productRepository.save(product);
		
	}
	
	@Test
	public void testDelete()
	{
		productRepository.deleteById(1);
	}

}
