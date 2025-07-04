package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hiber.entities.stud;
import com.hiber.util.hiberUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        com.hiber.entities.stud stud = new stud();
        
        stud.setStudname("Ganesh");
        stud.setCollege("VP");
        
        
        SessionFactory sessionFactory = hiberUtil.getSessionFactory();
        //System.out.println( sessionFactory );
        
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction=null;
        try {
        	
        	transaction=session.beginTransaction();
        	
        	
        	
        	session.persist(stud);
        	
        	transaction.commit();
        	
        	System.out.println("saved successfull");
        	
        } catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	
        	e.printStackTrace();
        } finally {
        	session.close();
        }
    }
}
