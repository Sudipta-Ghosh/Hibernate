package com.java.hibernate.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class UserEmploymentDetails {

	@Column(name="EMPLOYEE_COMPANY_NAME")
	private String CompanyName;
	@Column(name="EMPLOYEE_DESIGNATION")
	private String designation;
	@Column(name="EMPLOYEE_SALARY")
	private double salary;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="EMPLOYEE_COMPANY_STREET")),
	@AttributeOverride(name="pincode",column=@Column(name="EMPLOYEE_COMPANY_PINCODE")),
	@AttributeOverride(name="city",column=@Column(name="EMPLOYEE_COMPANY_CITY")),
	@AttributeOverride(name="state",column=@Column(name="EMPLOYEE_COMPANY_STATE"))}
	)
	private Address CompanyAddress;
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getCompanyAddress() {
		return CompanyAddress;
	}
	public void setCompanyAddress(Address companyAddress) {
		CompanyAddress = companyAddress;
	}
	
	
	

}
