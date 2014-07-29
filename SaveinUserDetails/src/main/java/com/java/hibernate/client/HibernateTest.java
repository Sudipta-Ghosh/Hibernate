package com.java.hibernate.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.dto.Address;
import com.java.hibernate.dto.UserDetails;
import com.java.hibernate.dto.UserEmploymentDetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		Address presentaddress=new Address();
		Address parmanentaddress=new Address();
		Address companyaddress1=new Address();
		Address companyaddress2=new Address();
		UserEmploymentDetails presentEmployment=new UserEmploymentDetails();
		UserEmploymentDetails previousEmployment=new UserEmploymentDetails();
		
		//user.setUserId(3);
		user.setUserName("First User");
		user.setJoiningDate(new Date());
		presentaddress.setStreet("First Present Street");
		presentaddress.setState("First Present State");
		presentaddress.setCity("First Present City");
		presentaddress.setPinCode(100001);
		user.setPresentaddress(presentaddress);
		user.setDescription("First Description");
			
		parmanentaddress.setStreet("First parmanent Street");
		parmanentaddress.setState("First parmanent State");
		parmanentaddress.setCity("First parmanent City");
		parmanentaddress.setPinCode(100002);
		user.setParmanentaddress(parmanentaddress);
		
		presentEmployment.setCompanyName("Present Company Name");
		companyaddress1.setStreet("Present company Street");
		companyaddress1.setState("Present company State");
		companyaddress1.setCity("Present company City");
		companyaddress1.setPinCode(100003);
		presentEmployment.setCompanyAddress(companyaddress1);
		presentEmployment.setDesignation("Present Company Designation");
		presentEmployment.setSalary(10000.87);
		user.getUserEmpDetails().add(presentEmployment);
		
		previousEmployment.setCompanyName("Previous Company Name");
		companyaddress2.setStreet("Previous company Street");
		companyaddress2.setState("Previous company State");
		companyaddress2.setCity("Previous company City");
		companyaddress2.setPinCode(100004);
		previousEmployment.setCompanyAddress(companyaddress2);
		previousEmployment.setDesignation("Previous Company Designation");
		previousEmployment.setSalary(5000.85);
		
		
		user.getUserEmpDetails().add(previousEmployment);
		
		
		
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session =factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		session=factory.openSession();
		session.beginTransaction();
		UserDetails userget=(UserDetails) session.get(UserDetails.class, 20);
		System.out.println("userget==="+userget.getUserName());
		session.close();

	}

}
