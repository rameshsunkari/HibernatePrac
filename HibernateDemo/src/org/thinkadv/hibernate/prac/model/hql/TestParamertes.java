package org.thinkadv.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestParamertes {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int minUserId = 5;
		String userName = "User26";
		
		// Below commented code is sql injection infectant.
		/*String minUserId = "5 or 1=1";

		Query query = session.createQuery("from UserHQLInfo where id >" + minUserId);*/
		
		// Code for Named Parameters
		/*Query query = session.createQuery("from UserHQLInfo where id > :id");
		query.setInteger("id", minUserId);*/
		
		// Code for Position Parameters
		Query query = session.createQuery("from UserHQLInfo where id > ? and name =?");
		query.setInteger(0, minUserId);
		query.setString(1, userName);

		List<UserHQLInfo> usersList = (List<UserHQLInfo>) query.list();
		session.getTransaction().commit();
		session.close();

		System.out.println("size of the result is :" + usersList.size());

		for (UserHQLInfo user : usersList) {
			System.out.println(user.getId() + "\t" + user.getName());
		}

	}

}
