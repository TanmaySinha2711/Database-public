package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YouTubeWidget;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;

public class WidgetDao {
	public static WidgetDao instance;
	public static WidgetDao getInstance() {
		if(instance==null)
			instance = new WidgetDao();
		
		return instance;
	}
	
	public void createWidgetForPage(int pageId, Widget widget) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into widget"
				+ "(ID, pageID, name, width, height, cssClass, cssStyle, order) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, widget.getWidget_id());
			stmt.setInt(2, pageId);
			stmt.setString(3, widget.getText());
			stmt.setInt(4, widget.getWidth());
			stmt.setInt(5, widget.getHealth());
			stmt.setString(6, widget.getCssClass());
			stmt.setString(7, widget.getCssStyle());
			stmt.setInt(8, widget.getOrder());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createYoutubeWidgetForPage(int pageId, YouTubeWidget widget) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into widget"
				+ "(ID, pageID, name, width, height, cssClass, cssStyle, order, Type, url, sharable, expandable) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, widget.getWidget_id());
			stmt.setInt(2, pageId);
			stmt.setString(3, widget.getText());
			stmt.setInt(4, widget.getWidth());
			stmt.setInt(5, widget.getHealth());
			stmt.setString(6, widget.getCssClass());
			stmt.setString(7, widget.getCssStyle());
			stmt.setInt(8, widget.getOrder());
			stmt.setString(9, "YouTube");
			stmt.setString(10, widget.getUrl());
			stmt.setBoolean(11, widget.isShareble());
			stmt.setBoolean(12, widget.isExapndable());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createHeadingWidgetForPage(int pageId, HeadingWidget widget) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into widget"
				+ "(ID, pageID, name, width, height, cssClass, cssStyle, order, Type, size) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, widget.getWidget_id());
			stmt.setInt(2, pageId);
			stmt.setString(3, widget.getText());
			stmt.setInt(4, widget.getWidth());
			stmt.setInt(5, widget.getHealth());
			stmt.setString(6, widget.getCssClass());
			stmt.setString(7, widget.getCssStyle());
			stmt.setInt(8, widget.getOrder());
			stmt.setString(9, "Heading");
			stmt.setInt(10, widget.getSize());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createHtmlWidgetForPage(int pageId, HtmlWidget widget) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into widget"
				+ "(ID, pageID, name, width, height, cssClass, cssStyle, order, Type, html) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, widget.getWidget_id());
			stmt.setInt(2, pageId);
			stmt.setString(3, widget.getText());
			stmt.setInt(4, widget.getWidth());
			stmt.setInt(5, widget.getHealth());
			stmt.setString(6, widget.getCssClass());
			stmt.setString(7, widget.getCssStyle());
			stmt.setInt(8, widget.getOrder());
			stmt.setString(9, "HTML");
			stmt.setString(10, widget.getHtml());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createImageWidgetForPage(int pageId, ImageWidget widget) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into widget"
				+ "(ID, pageID, name, width, height, cssClass, cssStyle, order, Type, src) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, widget.getWidget_id());
			stmt.setInt(2, pageId);
			stmt.setString(3, widget.getText());
			stmt.setInt(4, widget.getWidth());
			stmt.setInt(5, widget.getHealth());
			stmt.setString(6, widget.getCssClass());
			stmt.setString(7, widget.getCssStyle());
			stmt.setInt(8, widget.getOrder());
			stmt.setString(9, "Image");
			stmt.setString(10, widget.getSrc());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Collection<Widget> findAllWidgets(){
    	
    	Connection con = JdbcConnection.getConnection();
    	Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "select * from widget";
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Widget> widgets = new ArrayList<Widget>();
    	try {
			while(rs.next()) {
				Widget  widget = new Widget();
				widget.setWidget_id(rs.getInt("ID"));
				widget.setName(rs.getString("name"));
				widget.setType(rs.getString("Type"));
				widget.setPage_id(rs.getInt("PageID"));
				widget.setOrder(rs.getInt("order"));
				
				widgets.add(widget);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
    	return widgets;
    	
    }
	
	public Collection<Widget> findWidgetsForPage(int pageId){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from widget "
    			+ "where widget.pageID = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setInt(1, pageId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Widget> widgets = new ArrayList<Widget>();
    	try {
			while(rs.next()) {
				Widget  widget = new Widget();
				widget.setWidget_id(rs.getInt("ID"));
				widget.setName(rs.getString("name"));
				widget.setType(rs.getString("Type"));
				widget.setPage_id(rs.getInt("PageID"));
				widget.setOrder(rs.getInt("order"));
				
				widgets.add(widget);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
    	return widgets;
    	
    }
	
	public Widget findWidgetById(int widgetId){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from widget "
    			+ "where widget.ID = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setInt(1, widgetId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Widget widget = new Widget();
    	try {
    		if(rs.next()) {
    			widget.setWidget_id(rs.getInt("ID"));
				widget.setName(rs.getString("name"));
				widget.setType(rs.getString("Type"));
				widget.setPage_id(rs.getInt("PageID"));
				widget.setOrder(rs.getInt("order"));
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
    	return widget;
    	
    }
	
	public void updateWidget(int widgetId, Widget widget) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "update widget "
				+ "set name = ?, text =?, order = ?, height = ?, width = ?, cssClass = ?, cssStyle = ?"
				+ " where widget.ID = ? ";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, widget.getName());
			stmt.setString(2, widget.getText());
			stmt.setInt(3, widget.getOrder());
			stmt.setInt(4, widget.getHealth());
			stmt.setInt(5, widget.getWidth());
			stmt.setString(6, widget.getCssClass());
			stmt.setString(7, widget.getCssStyle());
			stmt.setInt(8, widgetId);
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteWidget(int widgetId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from widget "
				+ "where widget.ID = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, widgetId);
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
