package com.bradleyramsey.TeamManager;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecute {

	public static void main(String[] args) {
		DBConnectionManager dbcm = new DBConnectionManager("localhost", "TeamManager", 
				   "postgres", "password");
		try {
			Connection connection = dbcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			Player player = new Player();
			player.setFirstName("John");
			player.setLastName("Doe");
			player.setPosition("QB");
			player.setPlayerNumber(1);
			player.setHeight(72);
			player.setWeight(190);
			playerDAO.insert(player);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
