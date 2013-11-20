package org.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestSelect {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("select name from UserHQLInfo");

		List<String> usersList = (List<String>) query.list();
		session.getTransaction().commit();
		session.close();

		System.out.println("size of the result is :" + usersList.size());

		for (String user : usersList) {
			System.out.println(user);
		}
	}

}
