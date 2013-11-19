package org.hibernate.prac.test;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.prac.model.Address;
import org.hibernate.prac.model.UserAddress;
import org.hibernate.prac.model.UserDetails;

public class TestCreate {

	public static void main(String[] args) {
		
		Address addr = new Address();
		addr.setStreet("Employees Colony");
		addr.setCity("Hyderabad");
		addr.setState("Andhra Pradesh");
		addr.setCountry("India");
		addr.setPincode("500089");

		UserDetails user = new UserDetails();
		user.setHomeAddress(addr);
		user.setOfficeAddress(addr);
		user.setUserName("Ramesh Sunkari");
		user.setDescription("Test Date Insertion");
		user.setJoinedDate(new Date());
		
		/*UserDetails user2 = new UserDetails();
//		user.setUserId(43701);
		user2.setUserName("Ramesh Sunkari");
		user2.setDescription("Test Date Insertion");
		user2.setJoinedDate(new Date());*/


		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User Object retrieved is: " + user);
		session.getTransaction().commit();
		session.close();
				
		
		
	}

}
