package org.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestCache {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserHQLInfo user = (UserHQLInfo) session.get(UserHQLInfo.class, 1);

		UserHQLInfo user2 = (UserHQLInfo) session.get(UserHQLInfo.class, 1);

		System.out.println(user + "\n" + user2);

		session.getTransaction().commit();
		session.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		UserHQLInfo user3 = (UserHQLInfo) session2.get(UserHQLInfo.class, 1);
		System.out.println(user3);

		session2.getTransaction().commit();
		session2.close();

	}

}
