package swingGUIs;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bradleyramsey.TeamManager.DBConnectionManager;
import com.bradleyramsey.TeamManager.PlayerDAO;

public class SearchPlayerByNameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPaneSearchPlayer;
	private JTextField playerNameField;

	/**
	 * Create the frame.
	 */
	public SearchPlayerByNameGUI(DBConnectionManager dbcm) {
		setTitle("Search Player by Name");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 424);
		contentPaneSearchPlayer = new JPanel();
		contentPaneSearchPlayer.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneSearchPlayer);
		
		JLabel lblPlayerNameHeader = new JLabel("Search Player by Name");
		lblPlayerNameHeader.setBounds(97, 10, 211, 22);
		lblPlayerNameHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		playerNameField = new JTextField();
		playerNameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		playerNameField.setBounds(120, 42, 192, 34);
		playerNameField.setColumns(10);
		contentPaneSearchPlayer.setLayout(null);
		contentPaneSearchPlayer.add(lblPlayerNameHeader);
		contentPaneSearchPlayer.add(playerNameField);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerName.setBounds(10, 42, 119, 34);
		contentPaneSearchPlayer.add(lblPlayerName);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(135, 86, 119, 35);
		btnSubmit.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	try {
				    		Connection connection = dbcm.getConnection();
				    		PlayerDAO playerDAO = new PlayerDAO(connection);
				    		playerDAO.findByName(playerNameField.getText());
				    		setVisible(false); // Make Main Menu invisible
				    		dispose(); // Close Main Menu
				    		MainMenuGUI gui = new MainMenuGUI(dbcm); // Open Main Menu
				    		gui.setVisible(true); // Make Main Menu visible
				    	}catch (SQLException f) {
							f.printStackTrace();
							throw new RuntimeException();
						}
				    }
				  }
				);
		contentPaneSearchPlayer.add(btnSubmit);
	}

}
