package org.thinkadv.hibernate.prac.model.inheritance.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJoinedInheritance {

	public static void main(String[] args) {
		VehicleJoinedInfo vehicle = new VehicleJoinedInfo();
		vehicle.setName("Cycle");
		
		TwoWheelerJoinedInfo bike = new TwoWheelerJoinedInfo();
		bike.setName("Honda Unicorn");
		bike.setSteeringHandle("Bike Handle");
		
		FourWheelerJoinedInfo car = new FourWheelerJoinedInfo();
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
