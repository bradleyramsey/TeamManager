package swingGUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Test extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lastNameField;
	private JTextField textField;
	private JTextField heightField;
	private JTextField weightField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblLastName);
		
		lastNameField = new JTextField();
		contentPane.add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPosition);
		
		JComboBox<String> positionDropDown = new JComboBox<String>();
		contentPane.add(positionDropDown);
		
		JLabel lblPlayerNumber = new JLabel("Player Number:");
		lblPlayerNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPlayerNumber);
		
		JFormattedTextField playerNumberField = new JFormattedTextField();
		contentPane.add(playerNumberField);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblHeight);
		
		heightField = new JTextField();
		heightField.setColumns(10);
		contentPane.add(heightField);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblWeight);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		contentPane.add(weightField);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(219, 10, 103, 32);
		panel.add(btnNewButton);
	}
}
