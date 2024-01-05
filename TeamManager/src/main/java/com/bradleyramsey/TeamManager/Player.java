package com.bradleyramsey.TeamManager;

import utilsDB.DataTransferObject;

public class Player implements DataTransferObject {
	private long id;
	private String firstName;
	private String lastName;
	private int weight;
	private int height;
	private String position;
	private int playerNumber;
	
	public long getID() { return id; }
	
	public void setID(long id) { this.id = id; }
	
	public String getFirstName() { return firstName; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getLastName() { return lastName; }
	
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public int getHeight() { return height; }
	
	public void setHeight(int height) { this.height = height; }
	
	public int getWeight() { return weight; }
	
	public void setWeight(int weight) { this.weight = weight; }
	
	public int getPlayerNumber() { return playerNumber; }
	
	public void setPlayerNumber(int playerNumber) { this.playerNumber = playerNumber; }
	
	public String getPosition() { return position; }
	
	public void setPosition(String position) { this.position = position; }	
}
