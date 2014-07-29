package com.java.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="CreditCard")
@PrimaryKeyJoinColumn(name="PAYMENT_ID")
public class CreditCard extends Payment{

	private String CreditCardType;

	public String getCreditCardType() {
		return CreditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		CreditCardType = creditCardType;
	}

}