package com.java.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customers_seq")
	@SequenceGenerator(
		    name="customers_seq",
		    sequenceName="customers_seq",
		    allocationSize=20
		)
		 
	@Column(name="USER_ID")
	private int UserId;
	@Column(name="USER_NAME")
	private String UserName;
	@Column(name="JOINING_DATE")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="PRESENT_STREET")),
	@AttributeOverride(name="pincode",column=@Column(name="PRESENT_PINCODE")),
	@AttributeOverride(name="city",column=@Column(name="PRESENT_CITY")),
	@AttributeOverride(name="state",column=@Column(name="PRESENT_STATE"))}
	)
	private Address presentaddress;

	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="PARMANENT_STREET")),
	@AttributeOverride(name="pincode",column=@Column(name="PARMANENT_PINCODE")),
	@AttributeOverride(name="city",column=@Column(name="PARMANENT_CITY")),
	@AttributeOverride(name="state",column=@Column(name="PARMANENT_STATE"))}
	)
	private Address parmanentaddress;
	@Column(name="USER_DESCRIPTION")
	private String description;
	
	@ElementCollection
	@JoinTable(name="USER_EMPLOYMENT_DETAILS")
	@GenericGenerator(name = "hiloGen", strategy = "hilo")
	@CollectionId(columns = { @Column (name="Address")}, generator = "hiloGen", type = @Type(type="long"))
	Collection<UserEmploymentDetails> userEmpDetails=new ArrayList();
	
	
	public Collection<UserEmploymentDetails> getUserEmpDetails() {
		return userEmpDetails;
	}
	public void setUserEmpDetails(Collection<UserEmploymentDetails> userEmpDetails) {
		this.userEmpDetails = userEmpDetails;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	public Address getPresentaddress() {
		return presentaddress;
	}
	public void setPresentaddress(Address presentaddress) {
		this.presentaddress = presentaddress;
	}
	public Address getParmanentaddress() {
		return parmanentaddress;
	}
	public void setParmanentaddress(Address parmanentaddress) {
		this.parmanentaddress = parmanentaddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	

}
