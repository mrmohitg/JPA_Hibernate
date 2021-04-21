package com.springdata.compositKey.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductsId implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
