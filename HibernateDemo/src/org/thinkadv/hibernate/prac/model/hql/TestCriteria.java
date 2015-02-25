package org.thinkadv.hibernate.prac.model.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserHQLInfo.class);
		// criteria.add(Restrictions.gt("id", 5)).add(Restrictions.like("name", "%User1%"));
		// criteria.add(Restrictions.between("id", 0, 10)).add(Restrictions.like("name", "User1%"));
		criteria.add(Restrictions.and(Restrictions.between("id", 0, 10), Restrictions.like("name", "User%")));
		
		List<UserHQLInfo> usersList = (List<UserHQLInfo>) criteria.list();

		session.getTransaction().commit();
		session.close();
		for (UserHQLInfo user : usersList) {
			System.out.println(user);
		}
		

	}

}
