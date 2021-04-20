package com.springdata.mongoDemo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	private String id;
	private String name;
	private float price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
