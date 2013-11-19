package org.hibernate.prac.model.inheritance.table;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestTableInheritance {

	public static void main(String[] args) {
		VehicleTableInfo vehicle = new VehicleTableInfo();
		vehicle.setName("Cycle");
		
		TwoWheelerTableInfo bike = new TwoWheelerTableInfo();
		bike.setName("Honda Unicorn");
		bike.setSteeringHandle("Bike Handle");
		
		FourWheelerTableInfo car = new FourWheelerTableInfo();
		car.setName("Maruthi WagonR");
		car.setSteeringWheel("Power Steering");
		
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		session.close();
	}

}
