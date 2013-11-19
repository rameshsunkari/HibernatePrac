package org.hibernate.prac.model.inheritance.table;

import javax.persistence.Entity;

@Entity
public class TwoWheelerTableInfo extends VehicleTableInfo {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
