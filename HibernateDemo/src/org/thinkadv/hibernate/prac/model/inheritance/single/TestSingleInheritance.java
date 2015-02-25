package org.thinkadv.hibernate.prac.model.inheritance.single;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSingleInheritance {

	public static void main(String[] args) {
		VehicleInfo vehicle = new VehicleInfo();
		vehicle.setName("Cycle");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setName("Honda Unicorn");
		bike.setSteeringHandle("Bike Handle");
		
		FourWheeler car = new FourWheeler();
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
