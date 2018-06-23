package edu.northeastern.cs5200.models;

public class YouTubeWidget extends Widget{
	
	private String url;
	private boolean shareble;
	private boolean exapndable;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareble() {
		return shareble;
	}
	public void setShareble(boolean shareble) {
		this.shareble = shareble;
	}
	public boolean isExapndable() {
		return exapndable;
	}
	public void setExapndable(boolean exapndable) {
		this.exapndable = exapndable;
	}
	
	public YouTubeWidget(int widget_id, String name, int width, int health, String cssClass, String cssStyle,
			String text, int order, int page_id, String url, boolean shareble, boolean exapndable) {
		super(widget_id, name, width, health, cssClass, cssStyle, text, order, page_id);
		this.url = url;
		this.shareble = shareble;
		this.exapndable = exapndable;
	}
	public YouTubeWidget() {
		super();
	}

}
