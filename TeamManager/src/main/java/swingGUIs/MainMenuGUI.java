package swingGUIs;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bradleyramsey.TeamManager.DBConnectionManager;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCreatePlayer;
	
	/**
	 * Create the frame.
	 */
	public MainMenuGUI(DBConnectionManager dbcm) {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnCreatePlayer = new JButton("Create New Player");
		btnCreatePlayer.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				      setVisible(false); // Make Main Menu invisible
				      dispose(); // Close Main Menu
				      PlayerGUI gui = new PlayerGUI(dbcm); // Open Create Player Menu
				      gui.setVisible(true); // Make Create Player Menu visible
				    }
				  }
				);
		btnCreatePlayer.setBounds(15, 15, 283, 64);
		btnCreatePlayer.setBackground(SystemColor.activeCaptionBorder);
		btnCreatePlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));

		
		JButton btnSeachById = new JButton("Search By Player ID");
		btnSeachById.setBounds(15, 89, 283, 64);
		btnSeachById.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSeachById.setBackground(SystemColor.activeCaptionBorder);
		
		JButton btnSearchByPlayer = new JButton("Search By Player Name");
		btnSearchByPlayer.setBounds(15, 163, 283, 64);
		btnSearchByPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearchByPlayer.setBackground(SystemColor.activeCaptionBorder);
		
		JButton btnDeletePlayer = new JButton("Delete Player");
		btnDeletePlayer.setBounds(15, 237, 283, 64);
		btnDeletePlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeletePlayer.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setLayout(null);
		contentPane.add(btnCreatePlayer);
		contentPane.add(btnSeachById);
		contentPane.add(btnSearchByPlayer);
		contentPane.add(btnDeletePlayer);
	}
}
