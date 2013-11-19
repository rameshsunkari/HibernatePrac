package org.hibernate.prac.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.prac.model.UserDetails;

public class TestHibernate {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserId(43701);
		user.setUserName("Ramesh Sunkari");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
