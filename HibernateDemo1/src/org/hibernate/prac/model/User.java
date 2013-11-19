package org.hibernate.prac.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	// Seperate Table
	/*
	 * @OneToMany
	 * 
	 * @JoinTable(name="USER_VEHICLE_INFO",joinColumns = @JoinColumn(name =
	 * "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	 */
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "job_id")
	private Job job;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "USERS_BOOK", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private Collection<Books> books = new ArrayList<Books>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", vehicle=" + vehicle + ", job=" + job + "]";
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public Collection<Books> getBooks() {
		return books;
	}

	public void setBooks(Collection<Books> books) {
		this.books = books;
	}

}
