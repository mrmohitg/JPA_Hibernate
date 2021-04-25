package com.springdata.multipleDataSources.product.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.multipleDataSources.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
