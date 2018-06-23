package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.Page;

public class PageDao {
	public static PageDao instance;
	public static PageDao getInstance() {
		if(instance==null)
			instance = new PageDao();
		
		return instance;
	}
	
	public void createPageForWebsite(int websiteId, Page page) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into page"
				+ "(PageID, WebsiteID, name, views, created) "
				+ "values (?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, page.getPage_id());
			stmt.setInt(2, websiteId);
			stmt.setString(3, page.getTitle());
			stmt.setInt(4, page.getViews());
			
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			stmt.setDate(5, date);
			
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
	
	public Collection<Page> findAllPages(){
    	
    	Connection con = JdbcConnection.getConnection();
    	Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "select * from page";
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Page> pages = new ArrayList<Page>();
    	try {
			while(rs.next()) {
				Page page = new Page();
				page.setTitle(rs.getString("name"));
				page.setWebsite_id(rs.getInt("WebsiteID"));
				page.setPage_id(rs.getInt("PageID"));
				
				pages.add(page);
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
    	return pages;
    	
    }
	
	public Collection<Page> findPagesForWebsite(int websiteId){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from page "
    			+ "where page.WebsiteID = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setInt(1, websiteId);
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
		
		Collection<Page> pages = new ArrayList<Page>();
    	try {
			while(rs.next()) {
				Page page = new Page();
				page.setTitle(rs.getString("name"));
				page.setWebsite_id(rs.getInt("WebsiteID"));
				page.setPage_id(rs.getInt("PageID"));
				
				pages.add(page);
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
    	return pages;
    	
    }
	
	public Page findPageById(int page_id){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from page "
    			+ "where page.PageID = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setInt(1, page_id);
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
		
		Page page = new Page();
    	try {
    		if(rs.next()) {
    			page.setTitle(rs.getString("name"));
    			page.setWebsite_id(rs.getInt("WebsiteID"));
    			page.setPage_id(rs.getInt("PageID"));
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
    	return page;
    	
    }
	
	public void updatePage(int pageId, Page page) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "update page "
				+ "set name = ?, description =?, views = ?"
				+ " where PageID = ? ";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, page.getTitle());
			stmt.setString(2, page.getDescription());
			stmt.setInt(3, page.getViews());
			stmt.setInt(4, pageId);
			
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
	
	public void deletePage(int pageId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from page "
				+ "where page.PageID = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, pageId);
			
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
