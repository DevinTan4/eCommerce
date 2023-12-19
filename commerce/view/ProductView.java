package commerce.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView();
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
	public ProductView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(40, 56, 101, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel productImage = new JLabel("New label");
		productImage.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\indomie-kari.png"));
		productImage.setBounds(0, 0, 101, 86);
		panel.add(productImage);
		
		JLabel productName = new JLabel("<html>Indomie Kuah<br>Kari Ayam</html>");
		productName.setHorizontalAlignment(SwingConstants.TRAILING);
		productName.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName.setBounds(10, 84, 69, 26);
		panel.add(productName);
		
		JLabel lblNewLabel_1 = new JLabel("Rp 3100");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(239, 110, 32));
		lblNewLabel_1.setBounds(10, 129, 64, 19);
		panel.add(lblNewLabel_1);
		
		JButton addToCart = new JButton("+ Keranjang");
		addToCart.addActionListener(createAddToCartActionListener("Indomie Kuah Kari Ayam"));
		addToCart.setBackground(new Color(239, 110, 32));
		addToCart.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart.setForeground(new Color(255, 255, 255));
		addToCart.setBounds(0, 149, 101, 24);
		panel.add(addToCart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(162, 56, 101, 173);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel productImage1 = new JLabel("New label");
		productImage1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\indomie-rendang.png"));
		productImage1.setBounds(0, 0, 101, 85);
		panel_1.add(productImage1);
		
		JLabel productName1 = new JLabel("<html>Indomie Goreng<br>Rendang<html>");
		productName1.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName1.setHorizontalAlignment(SwingConstants.TRAILING);
		productName1.setBounds(10, 84, 81, 28);
		panel_1.add(productName1);
		
		JButton addToCart_1 = new JButton("+ Keranjang");
		addToCart_1.addActionListener(createAddToCartActionListener("Indomie Goreng Rendang"));
		addToCart_1.setForeground(Color.WHITE);
		addToCart_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_1.setBackground(new Color(239, 110, 32));
		addToCart_1.setBounds(0, 149, 101, 24);
		panel_1.add(addToCart_1);
		
		JLabel lblNewLabel_1_9 = new JLabel("Rp 3100");
		lblNewLabel_1_9.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_9.setBounds(10, 131, 64, 19);
		panel_1.add(lblNewLabel_1_9);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1.setBounds(289, 56, 101, 173);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel productImage2 = new JLabel("New label");
		productImage2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\pocky-cookies.png"));
		productImage2.setBounds(0, 0, 101, 85);
		panel_1_1.add(productImage2);
		
		JLabel productName2 = new JLabel("<html>Pocky Cookies &<br>Cream<html>");
		productName2.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName2.setBounds(10, 84, 85, 26);
		panel_1_1.add(productName2);
		
		JButton addToCart_2 = new JButton("+ Keranjang");
		addToCart_2.addActionListener(createAddToCartActionListener("Pocky Cookies & Cream"));
		addToCart_2.setForeground(Color.WHITE);
		addToCart_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_2.setBackground(new Color(239, 110, 32));
		addToCart_2.setBounds(0, 149, 101, 24);
		panel_1_1.add(addToCart_2);
		
		JLabel lblNewLabel_1_10 = new JLabel("Rp 8700");
		lblNewLabel_1_10.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_10.setBounds(10, 131, 64, 19);
		panel_1_1.add(lblNewLabel_1_10);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1.setBounds(417, 56, 101, 173);
		contentPane.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel productImage3 = new JLabel("New label");
		productImage3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\pocky-matcha.png"));
		productImage3.setBounds(0, 0, 101, 85);
		panel_1_1_1.add(productImage3);
		
		JLabel productName3 = new JLabel("Pocky Matcha");
		productName3.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName3.setBounds(10, 84, 66, 14);
		panel_1_1_1.add(productName3);
		
		JButton addToCart_3 = new JButton("+ Keranjang");
		addToCart_3.addActionListener(createAddToCartActionListener("Pocky Matcha"));
		addToCart_3.setForeground(Color.WHITE);
		addToCart_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_3.setBackground(new Color(239, 110, 32));
		addToCart_3.setBounds(0, 149, 101, 24);
		panel_1_1_1.add(addToCart_3);
		
		JLabel lblNewLabel_1_11 = new JLabel("Rp 8700");
		lblNewLabel_1_11.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_11.setBounds(10, 130, 64, 19);
		panel_1_1_1.add(lblNewLabel_1_11);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1.setBounds(546, 56, 101, 173);
		contentPane.add(panel_1_1_1_1);
		panel_1_1_1_1.setLayout(null);
		
		JLabel productImage4 = new JLabel("New label");
		productImage4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\samyang-original.png"));
		productImage4.setBounds(0, 0, 101, 85);
		panel_1_1_1_1.add(productImage4);
		
		JLabel productName4 = new JLabel("<html>Samyang Buldak<br>Original<html>");
		productName4.setHorizontalAlignment(SwingConstants.TRAILING);
		productName4.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName4.setBounds(10, 84, 83, 26);
		panel_1_1_1_1.add(productName4);
		
		JButton addToCart_4 = new JButton("+ Keranjang");
		addToCart_4.addActionListener(createAddToCartActionListener("Samyang Buldak Original"));
		addToCart_4.setForeground(Color.WHITE);
		addToCart_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_4.setBackground(new Color(239, 110, 32));
		addToCart_4.setBounds(0, 149, 101, 24);
		panel_1_1_1_1.add(addToCart_4);
		
		JLabel lblNewLabel_1_12 = new JLabel("Rp 23900");
		lblNewLabel_1_12.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_12.setBounds(10, 132, 74, 19);
		panel_1_1_1_1.add(lblNewLabel_1_12);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1_1.setBounds(40, 240, 101, 173);
		contentPane.add(panel_1_1_1_1_1);
		panel_1_1_1_1_1.setLayout(null);
		
		JLabel productImage5 = new JLabel("New label");
		productImage5.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\samyang-carbonara.png"));
		productImage5.setBounds(0, 0, 101, 85);
		panel_1_1_1_1_1.add(productImage5);
		
		JLabel productName5 = new JLabel("<html>Samyang Buldak<br>Carbonara<html>");
		productName5.setHorizontalAlignment(SwingConstants.TRAILING);
		productName5.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName5.setBounds(10, 84, 83, 26);
		panel_1_1_1_1_1.add(productName5);
		
		JButton addToCart_5 = new JButton("+ Keranjang");
		addToCart_5.addActionListener(createAddToCartActionListener("Samyang Buldak Carbonara"));
		addToCart_5.setForeground(Color.WHITE);
		addToCart_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_5.setBackground(new Color(239, 110, 32));
		addToCart_5.setBounds(0, 149, 101, 24);
		panel_1_1_1_1_1.add(addToCart_5);
		
		JLabel lblNewLabel_1_13 = new JLabel("Rp 21900");
		lblNewLabel_1_13.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_13.setBounds(10, 131, 74, 19);
		panel_1_1_1_1_1.add(lblNewLabel_1_13);
		
		JPanel panel_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1_1_1.setBounds(162, 240, 101, 173);
		contentPane.add(panel_1_1_1_1_1_1);
		panel_1_1_1_1_1_1.setLayout(null);
		
		JLabel productImage6 = new JLabel("New label");
		productImage6.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\daia.jpg"));
		productImage6.setBounds(0, 0, 101, 85);
		panel_1_1_1_1_1_1.add(productImage6);
		
		JLabel productName6 = new JLabel("<html>Daia Detergen<br>Bubuk Putih<html>");
		productName6.setHorizontalAlignment(SwingConstants.TRAILING);
		productName6.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName6.setBounds(10, 84, 73, 26);
		panel_1_1_1_1_1_1.add(productName6);
		
		JButton addToCart_6 = new JButton("+ Keranjang");
		addToCart_6.addActionListener(createAddToCartActionListener("Daia Detergen Bubuk Putih"));
		addToCart_6.setForeground(Color.WHITE);
		addToCart_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_6.setBackground(new Color(239, 110, 32));
		addToCart_6.setBounds(0, 149, 101, 24);
		panel_1_1_1_1_1_1.add(addToCart_6);
		
		JLabel lblNewLabel_1_14 = new JLabel("Rp 10000");
		lblNewLabel_1_14.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_14.setBounds(15, 132, 74, 19);
		panel_1_1_1_1_1_1.add(lblNewLabel_1_14);
		
		JPanel panel_1_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1_1_1_1.setBounds(289, 240, 101, 173);
		contentPane.add(panel_1_1_1_1_1_1_1);
		panel_1_1_1_1_1_1_1.setLayout(null);
		
		JLabel productImage7 = new JLabel("New label");
		productImage7.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\rinso.jpg"));
		productImage7.setBounds(0, 0, 101, 85);
		panel_1_1_1_1_1_1_1.add(productImage7);
		
		JLabel productName7 = new JLabel("Rinso Detergen");
		productName7.setHorizontalAlignment(SwingConstants.TRAILING);
		productName7.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName7.setBounds(10, 84, 77, 13);
		panel_1_1_1_1_1_1_1.add(productName7);
		
		JButton addToCart_7 = new JButton("+ Keranjang");
		addToCart_7.addActionListener(createAddToCartActionListener("Rinso Detergen"));
		addToCart_7.setForeground(Color.WHITE);
		addToCart_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_7.setBackground(new Color(239, 110, 32));
		addToCart_7.setBounds(0, 149, 101, 24);
		panel_1_1_1_1_1_1_1.add(addToCart_7);
		
		JLabel lblNewLabel_1_15 = new JLabel("Rp 10000");
		lblNewLabel_1_15.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_15.setBounds(10, 132, 74, 19);
		panel_1_1_1_1_1_1_1.add(lblNewLabel_1_15);
		
		JPanel panel_1_1_1_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1_1_1_1.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1_1_1_1_1.setBounds(417, 240, 101, 173);
		contentPane.add(panel_1_1_1_1_1_1_1_1);
		panel_1_1_1_1_1_1_1_1.setLayout(null);
		
		JLabel productImage8 = new JLabel("New label");
		productImage8.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\nu-original.png"));
		productImage8.setBounds(0, 0, 101, 85);
		panel_1_1_1_1_1_1_1_1.add(productImage8);
		
		JLabel productName8 = new JLabel("<html>Nu Greentea<br>Original<html>");
		productName8.setHorizontalAlignment(SwingConstants.TRAILING);
		productName8.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName8.setBounds(10, 84, 62, 26);
		panel_1_1_1_1_1_1_1_1.add(productName8);
		
		JButton addToCart_8 = new JButton("+ Keranjang");
		addToCart_8.addActionListener(createAddToCartActionListener("Nu Greentea Original"));
		addToCart_8.setForeground(Color.WHITE);
		addToCart_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_8.setBackground(new Color(239, 110, 32));
		addToCart_8.setBounds(0, 149, 101, 24);
		panel_1_1_1_1_1_1_1_1.add(addToCart_8);
		
		JLabel lblNewLabel_1_16 = new JLabel("Rp 4900");
		lblNewLabel_1_16.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_16.setBounds(10, 131, 64, 19);
		panel_1_1_1_1_1_1_1_1.add(lblNewLabel_1_16);
		
		JPanel panel_1_1_1_1_1_1_1_2 = new JPanel();
		panel_1_1_1_1_1_1_1_2.setBackground(new Color(192, 192, 192));
		panel_1_1_1_1_1_1_1_2.setBounds(546, 240, 101, 173);
		contentPane.add(panel_1_1_1_1_1_1_1_2);
		panel_1_1_1_1_1_1_1_2.setLayout(null);
		
		JLabel productImage9 = new JLabel("New label");
		productImage9.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\thaimilk-greentea.png"));
		productImage9.setBounds(0, 0, 101, 85);
		panel_1_1_1_1_1_1_1_2.add(productImage9);
		
		JLabel productName9 = new JLabel("<html>Thai Milk<br>Green Tea<html>");
		productName9.setHorizontalAlignment(SwingConstants.TRAILING);
		productName9.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName9.setBounds(10, 84, 52, 26);
		panel_1_1_1_1_1_1_1_2.add(productName9);
		
		JButton addToCart_9 = new JButton("+ Keranjang");
		addToCart_9.addActionListener(createAddToCartActionListener("Indomie "));
		addToCart_9.setForeground(Color.WHITE);
		addToCart_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_9.setBackground(new Color(239, 110, 32));
		addToCart_9.setBounds(0, 149, 101, 24);
		panel_1_1_1_1_1_1_1_2.add(addToCart_9);
		
		JLabel lblNewLabel_1_17 = new JLabel("Rp 9100");
		lblNewLabel_1_17.setForeground(new Color(239, 110, 32));
		lblNewLabel_1_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_17.setBounds(10, 131, 64, 19);
		panel_1_1_1_1_1_1_1_2.add(lblNewLabel_1_17);
	}
	
	private ActionListener createAddToCartActionListener(String productName) {
	    return new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                showMessage(productName + " added to cart successfully!");
	            } catch (Exception ex) {
	                showMessage("Error adding " + productName + " to cart: " + ex.getMessage());
	            }
	        }

	        private void showMessage(String message) {
	            JLabel label = new JLabel(message);
	            label.setFont(new Font("Tahoma", Font.PLAIN, 14));
	            JOptionPane.showMessageDialog(null, label, "Message", JOptionPane.INFORMATION_MESSAGE);
	        }
	    };
	}
}










