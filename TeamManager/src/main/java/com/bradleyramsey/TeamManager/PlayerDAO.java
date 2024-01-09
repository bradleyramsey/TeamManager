package com.bradleyramsey.TeamManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utilsDB.DataAccessObject;

public class PlayerDAO extends DataAccessObject<Player>{
	public static final String INSERT = "INSERT INTO player (first_name, last_name, "
			+ "position, player_number, height, weight) VALUES (?, ?, ?, ?, ?, ?)";
	
	public static final String DELETE = "DELETE FROM player WHERE player_id = ?";
	
	public PlayerDAO (Connection connection) {
		super(connection);
	}
	
	@Override
	public Player findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player update(Player dtObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player insert(Player dtObj) {
		try(PreparedStatement statement = this.connection.prepareStatement(INSERT);){
			statement.setString(1, dtObj.getFirstName());
			statement.setString(2, dtObj.getLastName());
			statement.setString(3, dtObj.getPosition());
			statement.setInt(4, dtObj.getPlayerNumber());
			statement.setInt(5, dtObj.getHeight());
			statement.setInt(6, dtObj.getWeight());
			statement.execute();
			return null;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(long id) {
		try (PreparedStatement statement = this.connection.prepareStatement(DELETE);){
			statement.setLong(1, id);
			statement.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
