package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Person {
	
	private int person_id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private Date dob;
	
	private Collection<Phone> phone;
	private Collection<Address> address;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Collection<Phone> getPhone() {
		return phone;
	}
	public void setPhone(Collection<Phone> phone) {
		this.phone = phone;
	}
	public Collection<Address> getAddress() {
		return address;
	}
	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public Person(int person_id, String firstname, String lastname, String username, String password, String email,
			Date dob, Collection<Phone> phone, Collection<Address> address) {
		super();
		this.person_id = person_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
	}
	public Person() {
		super();
	}
	
	
	
}
