package com.bradleyramsey.TeamManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionManager {
	private final String url;
	private final Properties properties;
	
	public DBConnectionManager(String host, String dbName,
							   String username, String password) {
		
		this.url = "jdbc:postgresql://"+host+"/"+dbName;
		this.properties = new Properties();
		this.properties.setProperty("user", username);
		this.properties.setProperty("password", password);
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(this.url, this.properties);
	}
}
