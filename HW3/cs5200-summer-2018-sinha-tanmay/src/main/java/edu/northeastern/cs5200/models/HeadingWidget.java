package edu.northeastern.cs5200.models;

public class HeadingWidget extends Widget{
	
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public HeadingWidget(int widget_id, String name, int width, int health, String cssClass, String cssStyle,
			String text, int order, int page_id, int size) {
		super(widget_id, name, width, health, cssClass, cssStyle, text, order, page_id);
		this.size = size;
	}

	public HeadingWidget() {
		super();
	}
}
