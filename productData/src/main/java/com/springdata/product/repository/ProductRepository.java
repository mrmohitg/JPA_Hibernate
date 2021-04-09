package com.springdata.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
