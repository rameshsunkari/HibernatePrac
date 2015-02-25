package org.thinkadv.hibernate.prac.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.thinkadv.hibernate.prac.model.UserInfo;

public class TestState {

	public static void main(String[] args) {

		UserInfo user = new UserInfo();
		user.setName("Sunkari Ramesh");
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(user);
		session.getTransaction().commit();
		session.close();
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		user.setName("Ramesh Sunkari");

		session.update(user);
		session.getTransaction().commit();
		session.close();

	}

}
