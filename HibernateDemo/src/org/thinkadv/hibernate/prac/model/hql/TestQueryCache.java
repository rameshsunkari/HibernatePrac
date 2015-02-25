package org.thinkadv.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestQueryCache {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserHQLInfo user where user.id = 1");
		query.setCacheable(true);
		List users = query.list();
		
		
		System.out.println(users.get(0));

		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from UserHQLInfo user where user.id = 1");
		query2.setCacheable(true);
		List users2 = query2.list();
		
		
		System.out.println(users2.get(0));
		
		
		session2.getTransaction().commit();
		session2.close();

		}

}
