package edu.northeastern.cs5200.models;

public class Widget {

	private int widget_id;
	private String name;
	private int width;
	private int health;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private int page_id;
	private String type;
	
	public Widget(int widget_id, String name, int width, int health, String cssClass, String cssStyle, String text,
			int order, int page_id) {
		super();
		this.widget_id = widget_id;
		this.name = name;
		this.width = width;
		this.health = health;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.page_id = page_id;
	}

	public Widget() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getWidget_id() {
		return widget_id;
	}
	public void setWidget_id(int widget_id) {
		this.widget_id = widget_id;
	}

	public int getPage_id() {
		return page_id;
	}

	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
