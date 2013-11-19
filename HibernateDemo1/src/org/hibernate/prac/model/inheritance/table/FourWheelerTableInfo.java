package org.hibernate.prac.model.inheritance.table;

import javax.persistence.Entity;

@Entity
public class FourWheelerTableInfo extends VehicleTableInfo {

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

}
