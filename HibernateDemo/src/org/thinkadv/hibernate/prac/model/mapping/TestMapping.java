package org.thinkadv.hibernate.prac.model.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMapping {

	public static void main(String[] args) {

		Job job = new Job();
		job.setJobName("Applications Engineer");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Honda Unicorn");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Honda Activa");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bajaj Discover");
		
		Books book1 = new Books();
		book1.setBookName("Hibernate In Action");

		Books book2 = new Books();
		book2.setBookName("Spring In Action");

		
		Books book3 = new Books();
		book3.setBookName("Struts In Action");

		
		User user = new User();
		user.setUserName("Sunkari Ramesh");
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		user.getBooks().add(book1);
		user.getBooks().add(book3);
		user.getBooks().add(book2);
		user.setJob(job);
		
		vehicle.setUser(user);
		vehicle1.setUser(user);
		vehicle2.setUser(user);
		
		book1.getUsers().add(user);
		book2.getUsers().add(user);
		book3.getUsers().add(user);
				
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(job);
		session.persist(user);
		session.getTransaction().commit();
		session.close();

	}

}
