package com.bradleyramsey.TeamManager;

import java.awt.EventQueue;

import swingGUIs.MainMenuGUI;

public class JDBCExecute {

	public static void main(String[] args) {
		DBConnectionManager dbcm = new DBConnectionManager("localhost", "TeamManager", 
				   "postgres", "password");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuGUI frame = new MainMenuGUI(dbcm);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
