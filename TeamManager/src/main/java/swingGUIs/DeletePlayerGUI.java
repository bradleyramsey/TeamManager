package swingGUIs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bradleyramsey.TeamManager.DBConnectionManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;

public class DeletePlayerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPaneDeletePlayer;
	private JTextField deletePlayerField;
	
	/**
	 * Create the frame.
	 */
	public DeletePlayerGUI(DBConnectionManager dbcm) {
		setTitle("Delete Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 424);
		contentPaneDeletePlayer = new JPanel();
		contentPaneDeletePlayer.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneDeletePlayer);
		
		JLabel lblDeletePlayer = new JLabel("Delete Player by ID");
		lblDeletePlayer.setBounds(97, 10, 157, 22);
		lblDeletePlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		deletePlayerField = new JTextField();
		deletePlayerField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deletePlayerField.setBounds(97, 42, 192, 34);
		deletePlayerField.setColumns(10);
		contentPaneDeletePlayer.setLayout(null);
		contentPaneDeletePlayer.add(lblDeletePlayer);
		contentPaneDeletePlayer.add(deletePlayerField);
		
		JLabel lblPlayerId = new JLabel("Player ID:");
		lblPlayerId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerId.setBounds(10, 42, 81, 34);
		contentPaneDeletePlayer.add(lblPlayerId);
		
		JTextArea textrNote = new JTextArea();
		textrNote.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textrNote.setBackground(SystemColor.menu);
		textrNote.setLineWrap(true);
		textrNote.setRows(4);
		textrNote.setWrapStyleWord(true);
		textrNote.setText("Note: If you do not know a player's ID, you can find the ID using the \"Search by Name\" section found in the Main Menu.");
		textrNote.setBounds(10, 132, 342, 70);
		contentPaneDeletePlayer.add(textrNote);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(135, 86, 119, 35);
		contentPaneDeletePlayer.add(btnSubmit);
	}
}
