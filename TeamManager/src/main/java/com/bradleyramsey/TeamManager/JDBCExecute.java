package com.bradleyramsey.TeamManager;

import swingGUIs.CreatePlayerGUI;

public class JDBCExecute {

	public static void main(String[] args) {
		DBConnectionManager dbcm = new DBConnectionManager("localhost", "TeamManager", 
				   "postgres", "password");
		CreatePlayerGUI gui = new CreatePlayerGUI(dbcm);
		gui.setVisible(true);
	}

}
