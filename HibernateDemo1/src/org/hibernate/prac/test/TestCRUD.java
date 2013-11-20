package org.hibernate.prac.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.prac.model.UserInfo;

public class TestCRUD {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// CREATE
		for (int i = 1; i <=30; i++) {
			UserInfo user = new UserInfo();

			user.setName("User" + i);
			session.save(user);
		}
		session.getTransaction().commit();
		session.close();
		
		UserInfo user = new UserInfo();
		session = sessionFactory.openSession();
		session.beginTransaction();
		// Retreive
		user = (UserInfo) session.get(UserInfo.class, 6);
		// Update
		user.setName("Updated User Name");
		session.update(user);
		
		// Delete
		user = (UserInfo) session.get(UserInfo.class, 5);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("User Object retrieved is: " + user);
		
				
		
		
	}

}
