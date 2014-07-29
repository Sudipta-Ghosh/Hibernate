package com.java.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="Cheque")
@PrimaryKeyJoinColumn(name="PAYMENT_ID")
public class Cheque extends Payment {
	
	private String ChequeType;

	public String getChequeType() {
		return ChequeType;
	}

	public void setChequeType(String chequeType) {
		ChequeType = chequeType;
	}

}
