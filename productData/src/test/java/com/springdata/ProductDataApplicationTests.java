package com.springdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdata.product.entity.Product;
import com.springdata.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductDataApplicationTests {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	EntityManager entityManager; 

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
	
	@Test
	public void testFindByNameAndDesc()
	{
		List<Product> listOfProduct = productRepository.findByNameAndDesc("MacBookPro","Super");
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindByPriceGreaterThan()
	{
		List<Product> listOfProduct = productRepository.findByPriceGreaterThan(100);
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindByDescContains()
	{
		List<Product> listOfProduct = productRepository.findByDescContains("Tiney");
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindByPriceBetween()
	{
		List<Product> listOfProduct = productRepository.findByPriceBetween(100,500);
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindByNameLike()
	{
		List<Product> listOfProduct = productRepository.findByNameLike("%Apple%");
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindByIdIn()
	{
		List<Product> listOfProduct = productRepository.findByIdIn(Arrays.asList(1,2,3,4));
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindAllPaging()
	{
		Pageable pageable = PageRequest.of(0, 2);
		Page<Product> listOfProduct = productRepository.findAll(pageable);
		listOfProduct.forEach(P -> System.out.println("Price of "+P.getName()+" is $"+P.getPrice()+"."));
	}
	
	@Test
	public void testFindAllSorting()
	{
		productRepository.findAll(Sort.by(new Sort.Order(Direction.ASC, "name"), new Sort.Order(null, "price")))
				.forEach(P -> System.out.println("Price of " + P.getName() + " is $" + P.getPrice() + "."));
	}
	
	@Test
	public void testFindAllPagingAndSorting()
	{
		Pageable pageable = PageRequest.of(0, 2, Direction.ASC, "name");
		productRepository.findAll(pageable)
				.forEach(P -> System.out.println("Price of " + P.getName() + " is $" + P.getPrice() + "."));
	}
	
	@Test
	public void testFindByIdInPageable()
	{
		Pageable pageable = PageRequest.of(0, 3, Direction.ASC, "name");
		productRepository.findByIdIn(Arrays.asList(1, 2, 3, 4), pageable)
				.forEach(P -> System.out.println("Price of " + P.getName() + " is $" + P.getPrice() + "."));
	}
	
	//Level 1 Cache is default one, Only one query will be seeing in the console
	@Test
	@Transactional
	public void testCaching()
	{
		productRepository.findById(1);
		productRepository.findById(1);
		productRepository.findById(1);
	}
	
	//Level 1 Cache is default one, two query will be seeing in the console
	@Test
	@Transactional
	public void testCachingLevel1()
	{
		Session session = entityManager.unwrap(Session.class);
		Optional<Product> product = productRepository.findById(1);
		Product p = product.get();
		productRepository.findById(1);
		session.evict(p);
		productRepository.findById(1);
	}
	
}
