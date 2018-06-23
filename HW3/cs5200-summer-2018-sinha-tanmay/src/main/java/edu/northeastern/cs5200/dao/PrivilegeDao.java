package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrivilegeDao {
	public static PrivilegeDao instance;
	public static PrivilegeDao getInstance() {
		if(instance==null)
			instance = new PrivilegeDao();
		
		return instance;
	}
	
	public void assignWebsitePrivilege(int developerId, int websiteId, int privilegeId, String privilege) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into websiteprivilege"
				+ "(PrivilegeId, developerID, websiteID, Privilege) "
				+ "values (?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, privilegeId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, websiteId);
			stmt.setString(4, privilege);
			
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
	
	public void assignPagePrivilege(int developerId, int pageId, int privilegeId, String privilege) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into pageprivilege"
				+ "(PrivilegeId, developerID, pageID, Privilege) "
				+ "values (?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, privilegeId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, pageId);
			stmt.setString(4, privilege);
			
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
	
	public void deleteWebsitePrivilege(int developerId, int websiteId, int privilegeId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from websiteprivilege "
				+ "where websiteID = ?"
				+ " and developerID = ? "
				+ "and PrivilegeId = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, websiteId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, privilegeId);
			
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
	
	public void deletePagePrivilege(int developerId, int pageId, int privilegeId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from pageprivilege "
				+ "where pageID = ?"
				+ " and developerID = ? "
				+ "and PrivilegeId = ?";
		
		try {
			stmt = con.prepareStatement(sql);
		
			stmt.setInt(1, pageId);
			stmt.setInt(2, developerId);
			stmt.setInt(3, privilegeId);
			
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
