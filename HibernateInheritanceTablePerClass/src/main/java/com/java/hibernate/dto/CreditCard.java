package com.java.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class CreditCard extends Payment{

	private String CreditCardType;

	public String getCreditCardType() {
		return CreditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		CreditCardType = creditCardType;
	}

}