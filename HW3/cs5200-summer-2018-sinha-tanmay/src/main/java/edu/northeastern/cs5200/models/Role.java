package edu.northeastern.cs5200.models;

enum RoleType{
	Owner,
	Admin,
	Writer,
	Editor,
	Reviewer
}
public class Role {

	private String role;
	private int developer_id;
	private int website_id;
	private int page_id;
	private int role_id;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Role(String role, int developer_id, int website_id, int page_id, int role_id) {
		super();
		this.role = role;
		this.developer_id = developer_id;
		this.website_id = website_id;
		this.page_id = page_id;
		this.role_id = role_id;
	}
	
	public Role() {
		super();
	}
	public int getDeveloper_id() {
		return developer_id;
	}
	public void setDeveloper_id(int developer_id) {
		this.developer_id = developer_id;
	}
	public int getWebsite_id() {
		return website_id;
	}
	public void setWebsite_id(int website_id) {
		this.website_id = website_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
}
