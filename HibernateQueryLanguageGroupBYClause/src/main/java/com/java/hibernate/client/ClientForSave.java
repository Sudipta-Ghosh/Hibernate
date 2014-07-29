package com.java.hibernate.client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.dto.Response;
import com.java.hibernate.dto.Student;



 
public class ClientForSave { 
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
 
    	 Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg.xml");
  
         SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
           
         String hql = "SELECT SUM(S.studentId),S.studentName  FROM Student S  GROUP BY S.studentName";
                 
         Query query = session.createQuery(hql);
         List results = query.list();
         
         for(int counter=0;counter<results.size();counter++){
        	  Object output[] = (Object[])results.get(counter);
        	  System.out.println("Sum----"+output[0]);
        	  System.out.println("studentName----"+output[1]);
         }
         
       
         
         session.close();
         factory.close();
    }
 
}