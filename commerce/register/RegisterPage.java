package commerce.register;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import commerce.login.LoginPage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField confirmPasswordField;
	private JTextField emailField;
	
	//JDBC Database, username, and password
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/account_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 110, 32));
		panel.setBounds(0, 0, 381, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Dokumen\\action\\logo_pradita_pemdas-removebg-preview.png"));
		lblNewLabel.setBounds(10, 70, 381, 152);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(380, 0, 271, 289);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1.setBounds(42, 25, 219, 63);
		panel_1.add(lblNewLabel_1);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameLabel.setBounds(20, 74, 67, 22);
		panel_1.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(20, 95, 241, 20);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(20, 161, 67, 22);
		panel_1.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 187, 239, 20);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmPasswordLabel.setBounds(22, 205, 126, 22);
		panel_1.add(confirmPasswordLabel);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(22, 226, 240, 20);
		panel_1.add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredUsername = usernameField.getText();
				String enteredEmail = emailField.getText();
                String enteredPassword = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                
                if (enteredPassword.equals(confirmPassword)) {
                	try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                        // Check if the username or email already exists
                        if (isUsernameOrEmailExists(connection, enteredUsername, enteredEmail)) {
                            JOptionPane.showMessageDialog(RegisterPage.this, "Username or Email already exists. Choose a different one.");
                        } else {
                            // Insert the new account
                            String query = "INSERT INTO account_tbl (username, email, password) VALUES (?, ?, ?)";
                            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                                preparedStatement.setString(1, enteredUsername);
                                preparedStatement.setString(2, enteredEmail);
                                preparedStatement.setString(3, enteredPassword);
                                preparedStatement.executeUpdate();
                            }
                            
                         // Add balance of 100000 to the new account
                            addInitialBalance(connection, enteredUsername);

                            JOptionPane.showMessageDialog(RegisterPage.this, "Registration Successful!");

                            // Open the LoginPage after successful registration
                            LoginPage loginPage = new LoginPage();
                            loginPage.setVisible(true);

                            // Close the current RegisterPage if needed
                            dispose();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(RegisterPage.this, "Error registering account. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(RegisterPage.this, "Password does not match. Try again.");
                    passwordField.setText("");
                    confirmPasswordField.setText("");
                }
			}
			
			//Check if the username or email already exists in database
			private boolean isUsernameOrEmailExists(Connection connection, String username, String email) throws SQLException {
		        String query = "SELECT COUNT(*) FROM account_tbl WHERE username = ? OR email = ?";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            preparedStatement.setString(1, username);
		            preparedStatement.setString(2, email);
		            try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                if (resultSet.next()) {
		                    return resultSet.getInt(1) > 0;
		                }
		            }
		        }
		        return false;
		    }
			
			private void addInitialBalance(Connection connection, String username) throws SQLException {
		        String updateBalanceQuery = "UPDATE account_tbl SET balance = ? WHERE username = ?";
		        try (PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceQuery)) {
		            updateBalanceStatement.setDouble(1, 100000.0);
		            updateBalanceStatement.setString(2, username);
		            updateBalanceStatement.executeUpdate();
		        }
		    }
		});
		signUpButton.setBackground(new Color(239, 110, 32));
		signUpButton.setBounds(96, 257, 89, 23);
		panel_1.add(signUpButton);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailLabel.setBounds(20, 118, 50, 22);
		panel_1.add(emailLabel);
		
		emailField = new JTextField();
		emailField.setBounds(20, 143, 241, 20);
		panel_1.add(emailField);
		emailField.setColumns(10);
	}
}
