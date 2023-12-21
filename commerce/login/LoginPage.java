package commerce.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import commerce.manager.AuthenticationManager;
import commerce.register.RegisterPage;
import commerce.user.User;
import commerce.view.ProductView;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 110, 32));
		panel.setBounds(0, 0, 406, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Dokumen\\action\\logo_pradita_pemdas-removebg-preview.png"));
		lblNewLabel.setBounds(-37, 39, 443, 181);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(403, 0, 267, 278);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_1.setBounds(78, 11, 126, 69);
		panel_1.add(lblNewLabel_1);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameLabel.setBounds(26, 73, 91, 23);
		panel_1.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(26, 97, 215, 20);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLabel.setBounds(26, 128, 91, 20);
		panel_1.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(26, 147, 215, 20);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String enteredUsername = usernameField.getText();
		        String enteredPassword = passwordField.getText();

		        if (isValidLogin(enteredUsername, enteredPassword)) {
		            User loggedInUser = getUserFromDatabase(enteredUsername); // You need to implement this method
		            AuthenticationManager.setLoggedInUser(loggedInUser);

		            JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");

		            openProductView();
		            dispose();
		        } else {
		            JOptionPane.showMessageDialog(LoginPage.this, "Invalid username or password. Try again.");
		            usernameField.setText("");
		            passwordField.setText("");
		        }
		    }
		});
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBackground(new Color(239, 110, 32));
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginButton.setBounds(93, 178, 89, 23);
		panel_1.add(loginButton);
		
		JLabel lblNewLabel_2 = new JLabel("Don't have an account? Make a new one here");
		lblNewLabel_2.setBounds(26, 212, 231, 14);
		panel_1.add(lblNewLabel_2);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterPage registerPage = new RegisterPage();
                registerPage.setVisible(true);

                //Close the current login page
                dispose();
			}
		});
		signUpButton.setBackground(new Color(239, 110, 32));
		signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signUpButton.setBounds(93, 230, 89, 23);
		panel_1.add(signUpButton);
	}
	
	private boolean isValidLogin(String username, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_db", "root", "")) {
            String query = "SELECT COUNT(*) FROM account_tbl WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next() && resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
	
	//Go to ProductView page
	private void openProductView() {
        EventQueue.invokeLater(() -> {
            try {
                ProductView productView = new ProductView();
                productView.setVisible(true);
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
	
	private User getUserFromDatabase(String username) {
	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/account_db", "root", "")) {
	        String query = "SELECT * FROM account_tbl WHERE username = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, username);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int userId = resultSet.getInt("id_account"); // Adjust this based on your database schema
	                    User user = new User(userId);
	                    double balance = resultSet.getDouble("balance"); // Adjust this based on your database schema
	                    user.setBalance(balance);
	                    return user;
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	