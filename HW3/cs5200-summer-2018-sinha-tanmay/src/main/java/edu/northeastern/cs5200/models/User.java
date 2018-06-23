package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class User extends Person {
	
	private boolean user_agreement;

	public boolean isUser_agreement() {
		return user_agreement;
	}

	public void setUser_agreement(boolean user_agreement) {
		this.user_agreement = user_agreement;
	}

	public User(int person_id, String firstname, String lastname, String username, String password, String email,
			Date dob, Collection<Phone> phone, Collection<Address> address, boolean user_agreement) {
		super(person_id, firstname, lastname, username, password, email, dob, phone, address);
		this.user_agreement = user_agreement;
	}

	public User(int person_id, String firstname, String lastname, String username, String password, String email,
			Date dob, Collection<Phone> phone, Collection<Address> address) {
		super(person_id, firstname, lastname, username, password, email, dob, phone, address);
	}
}
