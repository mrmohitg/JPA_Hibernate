package com.springdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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
		Product product;
		if(productRepository.existsById(1))
		{
			product = productRepository.findById(1).get();
			System.out.println("Deleting a product.");
			productRepository.delete(product);
		}
	}
	
	@Test
	public void testCount()
	{
			System.out.println("Total Records --------- "+productRepository.count());
	}
	
	
	@Test
	public void testFindByName()
	{
		List<Product> listOfProduct = productRepository.findByName("AppleTV");
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
}
