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
        String studentName="User";
        String grp="Group";
        for ( int i=0; i<101; i++ ) {
        	Student student = new Student();
        	studentName="User"+i;
        	grp="Group"+i;
        	student.setStudentName(studentName);
        	student.setGrp(grp);
            session.save(student);
            if ( i % 20 == 0 ) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
        }
        
        session.close();
        factory.close();
    }
 
}