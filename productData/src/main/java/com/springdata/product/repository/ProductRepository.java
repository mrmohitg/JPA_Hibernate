package com.springdata.product.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springdata.product.entity.Product;

public interface ProductRepository extends /*CrudRepository<Product, Integer>*/ PagingAndSortingRepository<Product, Integer> {
	
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name,String Desc);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(double priceOne, double priceTwo);
	
	List<Product> findByNameLike(String name);
	
	List<Product> findByIdIn(List<Integer> ids);
	
	List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
	
	@Query(value="CALL GetAllProducts", nativeQuery = true)
	List<Product> findAllProducts();
	
	@Query(value="CALL GetAllProductsByPrice (:price_in)", nativeQuery = true)
	List<Product> findAllProductsByPrice(double price_in);
	
	@Query(value="CALL GetAllProductsCountByPrice (:price_in)", nativeQuery = true)
	int findAllProductsCountByPrice(double price_in);

}
