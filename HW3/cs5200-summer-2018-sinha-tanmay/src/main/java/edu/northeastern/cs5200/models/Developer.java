package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Developer extends Person{

	private String developerKey;
	private Collection<Website> websites;

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public Collection<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}

	public Developer(int person_id, String firstname, String lastname, String username, String password, String email,
			Date dob, Collection<Phone> phone, Collection<Address> address, String developerKey,
			Collection<Website> websites) {
		super(person_id, firstname, lastname, username, password, email, dob, phone, address);
		this.developerKey = developerKey;
		this.websites = websites;
	}

	public Developer(int person_id, String firstname, String lastname, String username, String password, String email,
			Date dob, Collection<Phone> phone, Collection<Address> address) {
		super(person_id, firstname, lastname, username, password, email, dob, phone, address);
	}

	public Developer() {
		super();
	}

}
