package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionProvider {
	
	public static Connection createC() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Database information
			String userName = "root";
			String password = "pC12345@";
			String url = "jdbc:mysql://localhost:3306/ToDoManager";
			con = DriverManager.getConnection(url, userName, password);
		    return con;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
