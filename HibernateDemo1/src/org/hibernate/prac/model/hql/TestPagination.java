package org.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestPagination {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserHQLInfo");
		query.setFirstResult(11);
		query.setMaxResults(10);
		
		List<UserHQLInfo> usersList = (List<UserHQLInfo>) query.list();
		session.getTransaction().commit();
		session.close();
		
		System.out.println("size of the result is :" + usersList.size());
		
		for (UserHQLInfo user:usersList){
			System.out.println(user.getId() + "\t" + user.getName());
		}

	}

}
