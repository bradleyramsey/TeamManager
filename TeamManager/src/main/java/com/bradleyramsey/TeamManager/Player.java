package com.bradleyramsey.TeamManager;

public class Player {
	private long id;
	private String firstName;
	private String lastName;
	private int weight;
	private int height;
	private String position;
	
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
	
	public String getPosition() { return position; }
	
	public void setPosition(String position) { this.position = position; }	
}
