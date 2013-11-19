package org.hibernate.prac.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.prac.model.Address;
import org.hibernate.prac.model.UserAddress;
import org.hibernate.prac.model.UserAddressInfo;

public class TestHibernate {

	public static void main(String[] args) {
		
		Address addr1 = new Address();
		addr1.setStreet("Employees Colony");
		addr1.setCity("Hyderabad");
		addr1.setState("Andhra Pradesh");
		addr1.setCountry("India");
		addr1.setPincode("500089");
		
		Address addr2 = new Address();
		addr2.setStreet("Employees Colony");
		addr2.setCity("Hyderabad");
		addr2.setState("Andhra Pradesh");
		addr2.setCountry("India");
		addr2.setPincode("500089");

		UserAddressInfo user = new UserAddressInfo();
		user.setUserName("Ramesh Sunkari");
		user.getListOfAddress().add(addr1);
		user.getListOfAddress().add(addr2);
		
		/*UserAddress user2 = new UserAddress();
		user2.setUserName("Ramesh Sunkari");
		user2.getListOfAddress().add(addr1);
		user2.getListOfAddress().add(addr2);*/

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
//		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserAddressInfo) session.get(UserAddressInfo.class, 1);
//		System.out.println("User Object retrieved is: " + user);
		session.getTransaction().commit();
		session.close();
		System.out.println("User Address Object size is: " + user.getListOfAddress().size());
		


	}

}
