package swingGUIs;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import com.bradleyramsey.TeamManager.DBConnectionManager;
import com.bradleyramsey.TeamManager.Player;
import com.bradleyramsey.TeamManager.PlayerDAO;

public class CreatePlayerGUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	// Initialize DB Connection
	private DBConnectionManager dbcm;
	// Initialize GUI Objects
	private JButton button;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JComboBox<String> positionDropDown;
	private JPanel contentPane;
	private JFormattedTextField playerNumberField;
	private JFormattedTextField heightField;
	private JFormattedTextField weightField;
	// Constructor
	public CreatePlayerGUI(DBConnectionManager dbcm){
		this.dbcm = dbcm;
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    
	    
		setTitle("Enter Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblFirstName);
		
		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		contentPane.add(firstNameField);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblLastName);
		
		lastNameField = new JTextField();
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPosition);
		
		String[] positionStrings = {"QB", "RB", "WR", "TE", "OL", "DE", "DT", "LB", "CB", "S", "K", "P"};
		positionDropDown = new JComboBox<String>(positionStrings);
		contentPane.add(positionDropDown);
		
		JLabel lblPlayerNumber = new JLabel("Player Number:");
		lblPlayerNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPlayerNumber);
		
		playerNumberField = new JFormattedTextField(formatter);
		contentPane.add(playerNumberField);
		
		JLabel lblHeight = new JLabel("Height (Inches):");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblHeight);
		
		heightField = new JFormattedTextField(formatter);
		contentPane.add(heightField);
		
		JLabel lblWeight = new JLabel("Weight (lbs):");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblWeight);
		
		weightField = new JFormattedTextField(formatter);
		contentPane.add(weightField);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		button = new JButton("Submit");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(219, 10, 103, 32);
		button.addActionListener(this);
		panel.add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			if (validateForm()) {
				this.setVisible(false);
				this.dispose();
				try {
					Connection connection = dbcm.getConnection();
					PlayerDAO playerDAO = new PlayerDAO(connection);
					Player player = new Player();
					player.setFirstName(firstNameField.getText());
					player.setLastName(lastNameField.getText());
					player.setPosition(positionDropDown.getSelectedItem().toString());
					player.setPlayerNumber(Integer.parseInt(playerNumberField.getText()));
					player.setHeight(Integer.parseInt(heightField.getText()));
					player.setWeight(Integer.parseInt(weightField.getText()));
					playerDAO.insert(player);
				}catch(SQLException f) {
					f.printStackTrace();
				}
			}
		}
	}
	
	public boolean validateForm() {
		if (firstNameField.getText().length() > 0 && lastNameField.getText().length() > 0) {
			return true;
		}
		return false;
	}
}
