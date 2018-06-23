package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.Role;

public class RoleDao {
	public static RoleDao instance;
	public static RoleDao getInstance() {
		if(instance==null)
			instance = new RoleDao();
		
		return instance;
	}
	
	public void assignWebsiteRole(int developerId, int websiteId, int roleId, String role) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into websiterole"
				+ "(RoleId, developerID, websiteID, Role) "
				+ "values (?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, roleId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, websiteId);
			stmt.setString(4, role);
			
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
	
	public void assignPageRole(int developerId, int pageId, int roleId, String role) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into pagerole"
				+ "(RoleId, developerID, pageID, Role) "
				+ "values (?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, roleId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, pageId);
			stmt.setString(4, role);
			
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
	
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from websiterole "
				+ "where websiteID = ?"
				+ " and developerID = ? "
				+ "and RoleId = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, websiteId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, roleId);
			
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
	
	public void deletePageRole(int developerId, int pageId, int roleId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from pagerole "
				+ "where pageID = ?"
				+ " and developerID = ? "
				+ "and RoleId = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, pageId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, roleId);
			
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
	
	public Collection<Role> findAllPageRoles(){
    	
    	Connection con = JdbcConnection.getConnection();
    	Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "select * from pageroles";
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Role> roles = new ArrayList<Role>();
    	try {
			while(rs.next()) {
				Role  role = new Role();
				role.setRole_id(rs.getInt("RoleId"));
				role.setDeveloper_id(rs.getInt("developerID"));
				role.setPage_id(rs.getInt("pageID"));
				role.setRole(rs.getString("Role"));
				
				roles.add(role);
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
    	return roles;
    	
    }
}
