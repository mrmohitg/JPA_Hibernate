package com.springdata.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdata.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name,String Desc);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(double priceOne, double priceTwo);
	
	List<Product> findByNameLike(String name);
	
	List<Product> findByIdIn(List<Integer> ids);

}
