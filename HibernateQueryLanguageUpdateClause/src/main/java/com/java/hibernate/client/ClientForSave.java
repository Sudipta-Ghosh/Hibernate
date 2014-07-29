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
         
         String hql = "UPDATE Student set groupName = :groupname "  + 
                 "WHERE studentName = :studentname";
         Query query = session.createQuery(hql);  
         query.setParameter("studentname","User18");
         query.setParameter("groupname","Group21");
        
         int result = query.executeUpdate();
         System.out.println("Rows affected: " + result);         
         
         session.close();
         factory.close();
    }
 
}