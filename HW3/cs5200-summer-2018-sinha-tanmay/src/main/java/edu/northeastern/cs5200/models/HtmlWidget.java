package edu.northeastern.cs5200.models;

public class HtmlWidget extends Widget{
	
	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public HtmlWidget(int widget_id, String name, int width, int health, String cssClass, String cssStyle, String text,
			int order, int page_id, String html) {
		super(widget_id, name, width, health, cssClass, cssStyle, text, order, page_id);
		this.html = html;
	}

	public HtmlWidget() {
		super();
	}

}
