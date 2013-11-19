package org.hibernate.prac.model.inheritance.joined;

import javax.persistence.Entity;

@Entity
public class TwoWheelerJoinedInfo extends VehicleJoinedInfo {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
