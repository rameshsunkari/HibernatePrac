package org.hibernate.prac.model.inheritance.joined;

import javax.persistence.Entity;

@Entity
public class FourWheelerJoinedInfo extends VehicleJoinedInfo {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
