package com.springdata.hibernateInheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity

//For InheritanceType.SINGLE_TABLE 
//@DiscriminatorValue("CH")

//For InheritanceType.TABLE_PER_CLASS 
//@Table(name = "bankcheck")

//For InheritanceType.JOINED
@Table(name = "bankcheck")
@PrimaryKeyJoinColumn(name = "id")
public class Check extends Payment{
	
	@Column(name="checknumber")
	private String checkNumber;

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	

}
