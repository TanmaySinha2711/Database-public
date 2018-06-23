package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.models.*;

public class DeveloperDao {

	public static DeveloperDao instance;
	public static DeveloperDao getInstance() {
		if(instance==null)
			instance = new DeveloperDao();
		
		return instance;
	}
	
	public void createDeveloper(Developer developer) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		String insert_person = "insert into "
				+ "person(ID, firstname, lastname, username, password, email) "
				+ "values (?, ?, ?, ?, ?, ?)";
		String insert_developer = "insert into developer(ID, developer_key)"
				+ "values(?, ?)";
		try {
			stmt1 = con.prepareStatement(insert_person);
			stmt2 = con.prepareStatement(insert_developer);
			
			stmt1.setInt(1, developer.getPerson_id());
			stmt1.setString(2, developer.getFirstname());
			stmt1.setString(3, developer.getLastname());
			stmt1.setString(4, developer.getUsername());
			stmt1.setString(5, developer.getPassword());
			stmt1.setString(6, developer.getEmail());
			
			stmt2.setInt(1, developer.getPerson_id());
			stmt2.setString(2, developer.getDeveloperKey());
			
			stmt1.executeUpdate();
			stmt2.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt1.close();
				stmt2.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Collection<Developer> findAllDevelopers(){
    	
    	Connection con = JdbcConnection.getConnection();
    	Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String sql = "select * from developer inner join person on developer.ID = person.ID";
    	
    	ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collection<Developer> devs = new ArrayList<Developer>();
    	try {
			while(rs.next()) {
				Developer dev = new Developer();
				dev.setUsername(rs.getString("username"));
				dev.setPerson_id(rs.getInt("ID"));
				dev.setDeveloperKey(rs.getString("developer_key"));
				
				devs.add(dev);
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
    	return devs;
    	
    }
	
	public Developer findDeveloperById(int developerId){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from developer inner join person "
    			+ "on developer.ID = person.ID "
    			+ "where developer.ID = ?";
    	
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
		
		Developer dev = new Developer();
    	try {
    		if(rs.next()) {
    			dev.setUsername(rs.getString("username"));
    			dev.setPerson_id(rs.getInt("ID"));
    			dev.setDeveloperKey(rs.getString("developer_key"));
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
    	return dev;
    	
    }
	
	public Developer findDeveloperByUsername(String username){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from developer inner join person "
    			+ "on developer.ID = person.ID "
    			+ "where person.username = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setString(1, username);
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
		
		Developer dev = new Developer();
    	try {
    		if(rs.next()) {
    			dev.setUsername(rs.getString("username"));
    			dev.setPerson_id(rs.getInt("ID"));
    			dev.setDeveloperKey(rs.getString("developer_key"));
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
    	return dev;
    	
    }
	
	public Developer findDeveloperByCredentials(String username, String password){
    	
    	Connection con = JdbcConnection.getConnection();
    	PreparedStatement stmt = null;
    	String sql = "select * from developer inner join person "
    			+ "on developer.ID = person.ID "
    			+ "where person.username = ? "
    			+ "and person.password = ?";
    	
    	try {
			stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			stmt.setString(1, username);
			stmt.setString(2, password);
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
		
		Developer dev = new Developer();
    	try {
    		if(rs.next()) {
    			dev.setUsername(rs.getString("username"));
    			dev.setPerson_id(rs.getInt("ID"));
    			dev.setDeveloperKey(rs.getString("developer_key"));
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
    	return dev;
    	
    }
	
	public void updateDeveloper(int developerId, Developer developer) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		String update_person = "update person "
				+ "set firstname = ?, lastname = ?, username = ?, password = ?, email = ?"
				+ "where person.ID = ? ";
		String update_developer = "update developer "
				+ "set developer_key = ? "
				+ "where developer.ID = ?";
		try {
			stmt1 = con.prepareStatement(update_person);
			stmt2 = con.prepareStatement(update_developer);
			
			stmt1.setString(1, developer.getFirstname());
			stmt1.setString(2, developer.getLastname());
			stmt1.setString(3, developer.getUsername());
			stmt1.setString(4, developer.getPassword());
			stmt1.setString(5, developer.getEmail());
			stmt1.setInt(6, developerId);
			
			stmt2.setString(1, developer.getDeveloperKey());
			stmt2.setInt(2, developerId);
			
			stmt1.executeUpdate();
			stmt2.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt1.close();
				stmt2.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteDeveloper(int developerId) {
		Connection con = JdbcConnection.getConnection();
		PreparedStatement stmt = null;
		String delete_person = "delete from person "
				+ "where person.ID = ?";
		
		try {
			stmt = con.prepareStatement(delete_person);
		
			stmt.setInt(1, developerId);
			
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
