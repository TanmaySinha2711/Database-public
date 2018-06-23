package edu.northeastern.cs5200.models;

public class Phone {

	private String phone;
	private boolean primary;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
	public Phone(String phone, boolean primary) {
		super();
		this.phone = phone;
		this.primary = primary;
	}
	
	public Phone() {
		super();
	}
	
}
