package edu.northeastern.cs5200.models;

enum PrivilegeType{
	CREATE,
	READ,
	UPDATE,
	DELETE
}

public class Privilege {
	
	private PrivilegeType privilege;
	private int privilege_id;
	private int developer_id;
	private int website_id;
	private int page_id;
	public PrivilegeType getPrivilege() {
		return privilege;
	}
	public void setPrivilege(PrivilegeType privilege) {
		this.privilege = privilege;
	}
	public int getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(int privilege_id) {
		this.privilege_id = privilege_id;
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
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public Privilege(PrivilegeType privilege, int privilege_id, int developer_id, int website_id, int page_id) {
		super();
		this.privilege = privilege;
		this.privilege_id = privilege_id;
		this.developer_id = developer_id;
		this.website_id = website_id;
		this.page_id = page_id;
	}
	public Privilege() {
		super();
	}

}
