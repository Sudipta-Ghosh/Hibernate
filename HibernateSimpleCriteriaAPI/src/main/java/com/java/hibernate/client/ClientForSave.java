package com.java.hibernate.client;

import java.util.Iterator;
import java.util.List;
 




import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.java.hibernate.dto.Student;
 
public class ClientForSave { 
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
 
        Criteria cr = session.createCriteria(Student.class);
        cr.add(Restrictions.eq("grp", "mpc"));
        List results = cr.list();
        Iterator it=results.iterator();
        
        while(it.hasNext())
        {
        	Student p=(Student)it.next();
            System.out.println(p.getGrp());
            System.out.println(p.getStudentName());
            System.out.println(p.getStudentId());
            System.out.println("-----------------");
        }
 
        
        session.close();
        factory.close();
    }
 
}