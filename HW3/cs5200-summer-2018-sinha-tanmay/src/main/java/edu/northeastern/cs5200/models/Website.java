package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Website {
	
	private int website_id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	
	private Collection<Page> pages;
	private int developer_id;

	public Website(int website_id, String name, String description, Date created, Date updated, int visits,
			Collection<Page> pages, int developer_id) {
		super();
		this.website_id = website_id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.pages = pages;
		this.developer_id = developer_id;
	}

	public int getWebsite_id() {
		return website_id;
	}

	public void setWebsite_id(int website_id) {
		this.website_id = website_id;
	}

	public Website() {
		super();
	}

	public Website(Collection<Page> pages) {
		super();
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public Collection<Page> getPages() {
		return pages;
	}

	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}

	public int getDeveloper_id() {
		return developer_id;
	}

	public void setDeveloper_id(int developer_id) {
		this.developer_id = developer_id;
	}

}
