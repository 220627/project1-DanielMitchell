package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//This Class is where we manage and establish our database connection
public class ConnectionUtil {
	public static Logger log = LogManager.getLogger();
	public static Connection getConnection() throws SQLException {
	
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.warn("problem occurred locating driver");
		}
		
		String url = System.getenv("URL");
		String username = System.getenv("USERNAME");
	    String password = System.getenv("PASSWORD");
		
		return DriverManager.getConnection(url, username, password);
//      __
// (___()'`;
// /,    /`
// \\"--\\
	}
	
}
