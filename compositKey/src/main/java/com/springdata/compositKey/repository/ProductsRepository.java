package com.springdata.compositKey.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.compositKey.entity.Products;
import com.springdata.compositKey.entity.ProductsId;

public interface ProductsRepository extends CrudRepository<Products, ProductsId> {

}
