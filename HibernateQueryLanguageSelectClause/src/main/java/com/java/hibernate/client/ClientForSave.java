package com.java.hibernate.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.dto.Student;



 
public class ClientForSave { 
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
 
    	 Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg.xml");
  
         SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
         
         /****************SELECT SINGLE OBJECT*******************************/
  
         /*String hql = "SELECT S.groupName FROM Student S where S.studentName='User76'";
         Query query = session.createQuery(hql);
         List results = query.list();
      
         for (int counter=0;counter<results.size();counter++){
        	String groupName= (String) results.get(counter);
        	System.out.println("groupName==="+groupName);
         }*/
         /****************SELECT SINGLE OBJECT*******************************/
         
         /****************SELECT PARTIAL OBJECT*******************************/
         
        
         
        /* String hql = "SELECT S.groupName,S.studentName  FROM Student S ";
         
         Query query = session.createQuery(hql);
         List results = query.list();
         
         for(int counter=0;counter<results.size();counter++){
        	  Object output[] = (Object[])results.get(counter);
        	  System.out.println("Group Name----"+output[0]);
        	  System.out.println("Student Name----"+output[1]);
         }*/
         
         /****************SELECT SINGLE OBJECT*******************************/
         
         
         /****************SELECT ALL OBJECT*******************************/
         
         
         
       /*   String hql = "FROM Student S ";
          
          Query query = session.createQuery(hql);
          List results = query.list();
          
          for(int counter=0;counter<results.size();counter++){
         	  Student student=(Student) results.get(counter);
         	  System.out.println("Group Name----"+student.getGrp());
         	  System.out.println("Student Name----"+student.getStudentName());
          }
          
          /****************SELECT ALL OBJECT*******************************/
         
         /****************Using Named Paramters*******************************/
         
         String hql = "FROM Student S WHERE S.studentName = :studentName";
         Query query = session.createQuery(hql);
         query.setParameter("studentName","User18");
         List results = query.list();
         
         for(int counter=0;counter<results.size();counter++){
        	  Student student=(Student) results.get(counter);
        	  System.out.println("Group Name----"+student.getGrp());
        	  System.out.println("Student Name----"+student.getStudentName());
         }
         
         /****************Using Named Paramters*******************************/
         
         session.close();
         factory.close();
    }
 
}