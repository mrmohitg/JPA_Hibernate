package com.springdata.hibernateInheritance.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table

//For InheritanceType.SINGLE_TABLE
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)

//For InheritanceType.TABLE_PER_CLASS
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//For InheritanceType.JOINED
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {

	@Id
	private int id;
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
