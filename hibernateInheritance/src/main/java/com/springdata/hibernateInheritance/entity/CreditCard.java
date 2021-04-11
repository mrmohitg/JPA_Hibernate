package com.springdata.hibernateInheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity


//For InheritanceType.SINGLE_TABLE 
//@DiscriminatorValue("CC")

//For InheritanceType.TABLE_PER_CLASS 
//@Table(name = "card")

//For InheritanceType.JOINED
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "card")
public class CreditCard extends Payment{
	
	@Column(name = "cardnumber")
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


}
