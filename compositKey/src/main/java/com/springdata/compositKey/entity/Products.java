package com.springdata.compositKey.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Products {
	@EmbeddedId
	private ProductsId productsId;
	private float price;

	public ProductsId getProductsId() {
		return productsId;
	}

	public void setProductsId(ProductsId productsId) {
		this.productsId = productsId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
