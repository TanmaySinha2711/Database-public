package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/hw2_sinha_tanmay_2018";
    public static final String USER = "root";
    public static final String PASS = "Tanmay2711";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection()
    {
      try {
          Class.forName(JDBC_DRIVER);
          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
      }
	return null;
    }
}
