package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Page {
	
	private int page_id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int views;
	
	private Collection<Widget> widgets;
	private int website_id;
	
	public Page() {
		super();
	}
	
	public Page(int page_id, String title, String description, Date created, Date updated, int views,
			Collection<Widget> widgets, int website_id) {
		super();
		this.page_id = page_id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.widgets = widgets;
		this.website_id = website_id;
	}
	
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Collection<Widget> getWidgets() {
		return widgets;
	}
	public void setWidgets(Collection<Widget> widgets) {
		this.widgets = widgets;
	}
	public int getWebsite_id() {
		return website_id;
	}
	public void setWebsite_id(int website_id) {
		this.website_id = website_id;
	}
}
