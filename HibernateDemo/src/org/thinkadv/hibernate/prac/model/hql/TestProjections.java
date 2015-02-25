package org.thinkadv.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class TestProjections {

	public static void main(String[] args) {



		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserHQLInfo.class);
		criteria.setProjection(Projections.count("id"));
		List<Long> usersList = (List<Long>) criteria.list();

		session.getTransaction().commit();
		session.close();
		/*for (UserHQLInfo user : usersList) {
			System.out.println(user.getName());
		}*/

		for (Long user: usersList){
			System.out.println(user);
		}
	

	}

}
