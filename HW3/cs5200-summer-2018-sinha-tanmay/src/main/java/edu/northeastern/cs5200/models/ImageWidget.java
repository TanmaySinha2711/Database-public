package edu.northeastern.cs5200.models;

public class ImageWidget extends Widget{
	
	private String src;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public ImageWidget(int widget_id, String name, int width, int health, String cssClass, String cssStyle, String text,
			int order, int page_id, String src) {
		super(widget_id, name, width, health, cssClass, cssStyle, text, order, page_id);
		this.src = src;
	}

	public ImageWidget(String src) {
		super();
		this.src = src;
	}

}
