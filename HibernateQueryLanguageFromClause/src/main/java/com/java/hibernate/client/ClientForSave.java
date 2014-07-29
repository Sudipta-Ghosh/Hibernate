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
  
         String hql = "FROM Student";
         Query query = session.createQuery(hql);
         List results = query.list();
      
         for (int counter=0;counter<results.size();counter++){
        	Student student=(Student) results.get(counter);
        	System.out.println("name==="+student.getStudentName());
         }
         
         
         session.close();
         factory.close();
    }
 
}