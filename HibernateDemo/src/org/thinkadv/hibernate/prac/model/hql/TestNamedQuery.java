package org.thinkadv.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestNamedQuery {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.getNamedQuery("User.byId");
		query.setInteger("id", 10);
		
		List<UserHQLInfo> usersList = (List<UserHQLInfo>) query.list();
		

		session.getTransaction().commit();
		session.close();
		for (UserHQLInfo user : usersList) {
			System.out.println(user);
		}

	}

}
