package com.springdata.compositKey;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.compositKey.entity.Customers;
import com.springdata.compositKey.entity.Products;
import com.springdata.compositKey.entity.ProductsId;
import com.springdata.compositKey.repository.CustomersRepository;
import com.springdata.compositKey.repository.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CompositKeyApplicationTests {

	@Autowired
	private CustomersRepository customersRepository;

	@Autowired
	private ProductsRepository productsRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSaveCustomers() {
		Customers customers = new Customers();
		customers.setId(123);
		customers.setEmail("test@test.com");
		customers.setName("Test");
		customersRepository.save(customers);
	}

	@Test
	void testSaveProducts() {
		Products products = new Products();
		ProductsId productsId = new ProductsId();
		productsId.setId(1);
		productsId.setName("Diat Coke");
		products.setProductsId(productsId);
		products.setPrice(12.6F);
		productsRepository.save(products);
	}

}
