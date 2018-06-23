package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.*;

public class WebsiteDao {
	public static WebsiteDao instance;
	public static WebsiteDao getInstance() {
		if(instance==null)
			instance = new WebsiteDao();
		
		return instance;
	}
	
	public void createWebsiteForDeveloper(int developerId, Website website) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into website"
				+ "(WebsiteID, developerID, name, visits, created) "
				+ "values (?, ?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, website.getWebsite_id());
			stmt.setInt(2, developerId);
			stmt.setString(3, website.getName());
			stmt.setInt(4, website.getVisits());
			
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
	
	public Collection<Website> findAllWebsites(){
    	
    	Connection con = JdbcConnection.getConnection();
    	Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "select WebsiteID, name, developerID from website";
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Website> webs = new ArrayList<Website>();
    	try {
			while(rs.next()) {
				Website web = new Website();
				web.setName(rs.getString("name"));
				web.setWebsite_id(rs.getInt("WebsiteID"));
				web.setDeveloper_id(rs.getInt("developerID"));
				
				webs.add(web);
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
    	return webs;
    	
    }
	
	public Collection<Website> findWebsiteByDeveloperId(int developerId){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from website "
    			+ "where website.developerID = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setInt(1, developerId);
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
		
		Collection<Website> webs = new ArrayList<Website>();
    	try {
			while(rs.next()) {
				Website web = new Website();
				web.setName(rs.getString("name"));
				web.setWebsite_id(rs.getInt("WebsiteID"));
				web.setDeveloper_id(rs.getInt("developerID"));
				
				webs.add(web);
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
    	return webs;
    	
    }
	
	public Website findWebsiteById(int website_id){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from website "
    			+ "where website.WebsiteID = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setInt(1, website_id);
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
		
		Website web = new Website();
    	try {
    		if(rs.next()) {
    			web.setName(rs.getString("name"));
    			web.setWebsite_id(rs.getInt("WebsiteID"));
    			web.setDeveloper_id(rs.getInt("developerID"));
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
    	return web;
    	
    }
	
	public void updateWebsite(int websiteId, Website website) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "update website "
				+ "set name = ?, description =?, visits = ?"
				+ " where WebsiteID = ? ";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, website.getName());
			stmt.setString(2, website.getDescription());
			stmt.setInt(3, website.getVisits());
			stmt.setInt(4, websiteId);
			
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
	
	public void deleteWebsite(int websiteId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from website "
				+ "where website.WebsiteID = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, websiteId);
			
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
