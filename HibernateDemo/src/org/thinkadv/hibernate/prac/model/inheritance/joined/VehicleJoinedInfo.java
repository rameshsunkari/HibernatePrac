package org.thinkadv.hibernate.prac.model.inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="VEHICLE_INFO_JOINED")
public class VehicleJoinedInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private Long licenceNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(Long licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	
	
}
