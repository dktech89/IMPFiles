package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.util.HibernateUtil;


public class SaveTest {
	public static void main(String[] args) {
		
		Session session=null;
		EmpDetails details=null;
		
		Transaction tx=null;
		// Activate HB 
		
		
		
		// Build Session 
		
		session=HibernateUtil.getSession();
		// Prepare object for Domain Class having Data
		details=new EmpDetails();	details.setNo(1212);details.setFname("Dharmendra");details.setLname("Kumar Prajapati");details.setMail("dkp@gmail.com");
		/*details=new EmpDetails();
		details=session.get(EmpDetails.class, 1212);
		*/
		
	// Save Obj using ses.persist(-)
		
	
		
		try{
			
		tx=session.beginTransaction();
		
		//details.setMail("xyz1@gmail.com");;
		session.save(details);	
			tx.commit();
			System.out.println("Object is saved/Record is inserted"); 
		}catch(Exception ex)
		{
			tx.rollback();
			System.out.println("Some Exception Occurs:"+ex.getMessage());
		}
		
		//close session
		HibernateUtil.closeSession();
		// close Session Factory
		
	}// Main
}//Class
