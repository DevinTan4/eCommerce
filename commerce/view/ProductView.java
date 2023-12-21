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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		
		JLabel productPrice = new JLabel("Rp 3100");
		productPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice.setForeground(new Color(239, 110, 32));
		productPrice.setBounds(10, 129, 64, 19);
		panel.add(productPrice);
		
		JButton addToCart = new JButton("+ Keranjang");
		addToCart.addActionListener(createAddToCartActionListener("Indomie Kuah Kari Ayam", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\indomie-kari.png", 3100));
		addToCart.setBackground(new Color(239, 110, 32));
		addToCart.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart.setForeground(new Color(255, 255, 255));
		addToCart.setBounds(0, 149, 101, 24);
		panel.add(addToCart);
		
		JLabel lblNewLabel = new JLabel("Stok: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 109, 37, 14);
		panel.add(lblNewLabel);
		
		JLabel productStock = new JLabel("20");
		productStock.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock.setBounds(33, 109, 28, 14);
		panel.add(productStock);
		
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
		addToCart_1.addActionListener(createAddToCartActionListener("Indomie Goreng Rendang", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\indomie-rendang.png", 3100));
		productImage1.setBounds(0, 0, 101, 85);
		addToCart_1.setForeground(Color.WHITE);
		addToCart_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_1.setBackground(new Color(239, 110, 32));
		addToCart_1.setBounds(0, 149, 101, 24);
		panel_1.add(addToCart_1);
		
		JLabel productPrice1 = new JLabel("Rp 3100");
		productPrice1.setForeground(new Color(239, 110, 32));
		productPrice1.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice1.setBounds(10, 131, 64, 19);
		panel_1.add(productPrice1);
		
		JLabel lblNewLabel_1 = new JLabel("Stok: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(10, 110, 35, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel productStock1 = new JLabel("30");
		productStock1.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock1.setBounds(33, 110, 28, 14);
		panel_1.add(productStock1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(289, 56, 101, 173);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel productImage2 = new JLabel("New label");
		productImage2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\pocky-cookies.png"));
		productImage2.setBounds(0, 0, 101, 85);
		panel_2.add(productImage2);
		
		JLabel productName2 = new JLabel("<html>Pocky Cookies &<br>Cream<html>");
		productName2.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName2.setBounds(10, 84, 85, 26);
		panel_2.add(productName2);
		
		JButton addToCart_2 = new JButton("+ Keranjang");
		addToCart_2.addActionListener(createAddToCartActionListener("Pocky Cookies & Cream", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\pocky-cookies.png", 8700));
		addToCart_2.setForeground(Color.WHITE);
		addToCart_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_2.setBackground(new Color(239, 110, 32));
		addToCart_2.setBounds(0, 149, 101, 24);
		panel_2.add(addToCart_2);
		
		JLabel productPrice2 = new JLabel("Rp 8700");
		productPrice2.setForeground(new Color(239, 110, 32));
		productPrice2.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice2.setBounds(10, 131, 64, 19);
		panel_2.add(productPrice2);
		
		JLabel lblNewLabel_2 = new JLabel("Stok: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(10, 108, 35, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel productStock2 = new JLabel("25");
		productStock2.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock2.setBounds(33, 108, 28, 14);
		panel_2.add(productStock2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(417, 56, 101, 173);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel productImage3 = new JLabel("New label");
		productImage3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\pocky-matcha.png"));
		productImage3.setBounds(0, 0, 101, 85);
		panel_3.add(productImage3);
		
		JLabel productName3 = new JLabel("Pocky Matcha");
		productName3.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName3.setBounds(10, 84, 66, 14);
		panel_3.add(productName3);
		
		JButton addToCart_3 = new JButton("+ Keranjang");
		addToCart_3.addActionListener(createAddToCartActionListener("Pocky Matcha", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\pocky-matcha.png", 8700));
		addToCart_3.setForeground(Color.WHITE);
		addToCart_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_3.setBackground(new Color(239, 110, 32));
		addToCart_3.setBounds(0, 149, 101, 24);
		panel_3.add(addToCart_3);
		
		JLabel productPrice3 = new JLabel("Rp 8700");
		productPrice3.setForeground(new Color(239, 110, 32));
		productPrice3.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice3.setBounds(10, 130, 64, 19);
		panel_3.add(productPrice3);
		
		JLabel lblNewLabel_3 = new JLabel("Stok: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(10, 109, 35, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel productStock3 = new JLabel("35");
		productStock3.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock3.setBounds(33, 109, 28, 14);
		panel_3.add(productStock3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(546, 56, 101, 173);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel productImage4 = new JLabel("New label");
		productImage4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\samyang-original.png"));
		productImage4.setBounds(0, 0, 101, 85);
		panel_4.add(productImage4);
		
		JLabel productName4 = new JLabel("<html>Samyang Buldak<br>Original<html>");
		productName4.setHorizontalAlignment(SwingConstants.TRAILING);
		productName4.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName4.setBounds(10, 84, 83, 26);
		panel_4.add(productName4);
		
		JButton addToCart_4 = new JButton("+ Keranjang");
		addToCart_4.addActionListener(createAddToCartActionListener("Samyang Buldak Original", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\samyang-original.png", 23900));
		addToCart_4.setForeground(Color.WHITE);
		addToCart_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_4.setBackground(new Color(239, 110, 32));
		addToCart_4.setBounds(0, 149, 101, 24);
		panel_4.add(addToCart_4);
		
		JLabel productPrice4 = new JLabel("Rp 23900");
		productPrice4.setForeground(new Color(239, 110, 32));
		productPrice4.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice4.setBounds(10, 132, 74, 19);
		panel_4.add(productPrice4);
		
		JLabel lblNewLabel_4 = new JLabel("Stok: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(10, 107, 35, 14);
		panel_4.add(lblNewLabel_4);
		
		JLabel productStock4 = new JLabel("20");
		productStock4.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock4.setBounds(33, 107, 28, 14);
		panel_4.add(productStock4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBounds(40, 240, 101, 173);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel productImage5 = new JLabel("New label");
		productImage5.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\samyang-carbonara.png"));
		productImage5.setBounds(0, 0, 101, 85);
		panel_5.add(productImage5);
		
		JLabel productName5 = new JLabel("<html>Samyang Buldak<br>Carbonara<html>");
		productName5.setHorizontalAlignment(SwingConstants.TRAILING);
		productName5.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName5.setBounds(10, 84, 83, 26);
		panel_5.add(productName5);
		
		JButton addToCart_5 = new JButton("+ Keranjang");
		addToCart_5.addActionListener(createAddToCartActionListener("Samyang Buldak Carbonara", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\samyang-carbonara.png", 21900));
		addToCart_5.setForeground(Color.WHITE);
		addToCart_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_5.setBackground(new Color(239, 110, 32));
		addToCart_5.setBounds(0, 149, 101, 24);
		panel_5.add(addToCart_5);
		
		JLabel productPrice5 = new JLabel("Rp 21900");
		productPrice5.setForeground(new Color(239, 110, 32));
		productPrice5.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice5.setBounds(10, 131, 74, 19);
		panel_5.add(productPrice5);
		
		JLabel lblNewLabel_5 = new JLabel("Stok: ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setBounds(10, 106, 35, 14);
		panel_5.add(lblNewLabel_5);
		
		JLabel productStock5 = new JLabel("20");
		productStock5.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock5.setBounds(33, 106, 28, 14);
		panel_5.add(productStock5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBounds(162, 240, 101, 173);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel productImage6 = new JLabel("New label");
		productImage6.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\daia.jpg"));
		productImage6.setBounds(0, 0, 101, 85);
		panel_6.add(productImage6);
		
		JLabel productName6 = new JLabel("<html>Daia Detergen<br>Bubuk Putih<html>");
		productName6.setHorizontalAlignment(SwingConstants.TRAILING);
		productName6.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName6.setBounds(10, 84, 73, 26);
		panel_6.add(productName6);
		
		JButton addToCart_6 = new JButton("+ Keranjang");
		addToCart_6.addActionListener(createAddToCartActionListener("Daia Detergen Bubuk Putih", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\daia.jpg", 10000));
		addToCart_6.setForeground(Color.WHITE);
		addToCart_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_6.setBackground(new Color(239, 110, 32));
		addToCart_6.setBounds(0, 149, 101, 24);
		panel_6.add(addToCart_6);
		
		JLabel productPrice6 = new JLabel("Rp 10000");
		productPrice6.setForeground(new Color(239, 110, 32));
		productPrice6.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice6.setBounds(15, 132, 74, 19);
		panel_6.add(productPrice6);
		
		JLabel lblNewLabel_6 = new JLabel("Stok: ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setBounds(10, 107, 35, 14);
		panel_6.add(lblNewLabel_6);
		
		JLabel productStock6 = new JLabel("40");
		productStock6.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock6.setBounds(33, 107, 28, 14);
		panel_6.add(productStock6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setBounds(289, 240, 101, 173);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel productImage7 = new JLabel("New label");
		productImage7.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\rinso.jpg"));
		productImage7.setBounds(0, 0, 101, 85);
		panel_7.add(productImage7);
		
		JLabel productName7 = new JLabel("Rinso Detergen");
		productName7.setHorizontalAlignment(SwingConstants.TRAILING);
		productName7.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName7.setBounds(10, 84, 77, 13);
		panel_7.add(productName7);
		
		JButton addToCart_7 = new JButton("+ Keranjang");
		addToCart_7.addActionListener(createAddToCartActionListener("Rinso Detergen", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\rinso.jpg", 10000));
		addToCart_7.setForeground(Color.WHITE);
		addToCart_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_7.setBackground(new Color(239, 110, 32));
		addToCart_7.setBounds(0, 149, 101, 24);
		panel_7.add(addToCart_7);
		
		JLabel productPrice7 = new JLabel("Rp 10000");
		productPrice7.setForeground(new Color(239, 110, 32));
		productPrice7.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice7.setBounds(10, 132, 74, 19);
		panel_7.add(productPrice7);
		
		JLabel lblNewLabel_7 = new JLabel("Stok: ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_7.setBounds(10, 108, 35, 14);
		panel_7.add(lblNewLabel_7);
		
		JLabel productStock7 = new JLabel("40");
		productStock7.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock7.setBounds(33, 108, 28, 14);
		panel_7.add(productStock7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(192, 192, 192));
		panel_8.setBounds(417, 240, 101, 173);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel productImage8 = new JLabel("New label");
		productImage8.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\nu-original.png"));
		productImage8.setBounds(0, 0, 101, 85);
		panel_8.add(productImage8);
		
		JLabel productName8 = new JLabel("<html>Nu Greentea<br>Original<html>");
		productName8.setHorizontalAlignment(SwingConstants.TRAILING);
		productName8.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName8.setBounds(10, 84, 62, 26);
		panel_8.add(productName8);
		
		JButton addToCart_8 = new JButton("+ Keranjang");
		addToCart_8.addActionListener(createAddToCartActionListener("Nu Greentea Original", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\nu-original.png", 4900));
		addToCart_8.setForeground(Color.WHITE);
		addToCart_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_8.setBackground(new Color(239, 110, 32));
		addToCart_8.setBounds(0, 149, 101, 24);
		panel_8.add(addToCart_8);
		
		JLabel productPrice8 = new JLabel("Rp 4900");
		productPrice8.setForeground(new Color(239, 110, 32));
		productPrice8.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice8.setBounds(10, 131, 64, 19);
		panel_8.add(productPrice8);
		
		JLabel lblNewLabel_8 = new JLabel("Stok: ");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8.setBounds(10, 110, 35, 14);
		panel_8.add(lblNewLabel_8);
		
		JLabel productStock8 = new JLabel("50");
		productStock8.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock8.setBounds(33, 110, 28, 14);
		panel_8.add(productStock8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(192, 192, 192));
		panel_9.setBounds(546, 240, 101, 173);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel productImage9 = new JLabel("New label");
		productImage9.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\thaimilk-greentea.png"));
		productImage9.setBounds(0, 0, 101, 85);
		panel_9.add(productImage9);
		
		JLabel productName9 = new JLabel("<html>Thai Milk<br>Green Tea<html>");
		productName9.setHorizontalAlignment(SwingConstants.TRAILING);
		productName9.setFont(new Font("Tahoma", Font.BOLD, 10));
		productName9.setBounds(10, 82, 52, 26);
		panel_9.add(productName9);
		
		JButton addToCart_9 = new JButton("+ Keranjang");
		addToCart_9.addActionListener(createAddToCartActionListener("Thai Milk Green Tea", "C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Products\\thaimilk-greentea.png", 9100));
		addToCart_9.setForeground(Color.WHITE);
		addToCart_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		addToCart_9.setBackground(new Color(239, 110, 32));
		addToCart_9.setBounds(0, 149, 101, 24);
		panel_9.add(addToCart_9);
		
		JLabel productPrice9 = new JLabel("Rp 9100");
		productPrice9.setForeground(new Color(239, 110, 32));
		productPrice9.setFont(new Font("Tahoma", Font.BOLD, 15));
		productPrice9.setBounds(10, 131, 64, 19);
		panel_9.add(productPrice9);
		
		JLabel lblNewLabel_9 = new JLabel("Stok: ");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setBounds(10, 106, 35, 14);
		panel_9.add(lblNewLabel_9);
		
		JLabel productStock9 = new JLabel("50");
		productStock9.setHorizontalAlignment(SwingConstants.TRAILING);
		productStock9.setBounds(33, 106, 28, 14);
		panel_9.add(productStock9);
		
		JLabel cartIcon = new JLabel("");
		cartIcon.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\cart (2).png"));
		cartIcon.setBounds(619, 11, 28, 22);
		contentPane.add(cartIcon);
		
		JLabel historyIcon = new JLabel("");
		historyIcon.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\eCommerce\\src\\commerce.assets\\Icons\\history-icon (1).png"));
		historyIcon.setBounds(578, 11, 38, 22);
		contentPane.add(historyIcon);
		
		// Add ActionListener to cartIcon
        cartIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open ShoppingCartView when cartIcon is clicked
                openShoppingCartView();
            }
        });
        
        historyIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Open HistoryView when historyIcon is clicked
                openHistoryView();
            }
        });
	}
	
	private ActionListener createAddToCartActionListener(String productName, String imagePath, double productPrice) {
	    return new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                showMessage(productName + " added to cart successfully!");
	                ShoppingCartView shoppingCartView = new ShoppingCartView();
	                
	                shoppingCartView.addToCart(productName, productPrice, 1);
	                shoppingCartView.setProductImage(imagePath);
	                shoppingCartView.setVisible(true);
	                ProductView.this.setVisible(false);
	            } catch (Exception ex) {
	                showMessage("Error adding " + productName + " to cart: " + ex.getMessage());
	                ex.printStackTrace();
	            }
	        }

	        private void showMessage(String message) {
	            JLabel label = new JLabel(message);
	            label.setFont(new Font("Tahoma", Font.PLAIN, 14));
	            JOptionPane.showMessageDialog(null, label, "Message", JOptionPane.INFORMATION_MESSAGE);
	        }
	    };
	}
	
	//Open ShoppingCartView function
	private void openShoppingCartView() {
        // Create an instance of ShoppingCartView
        ShoppingCartView shoppingCartView = new ShoppingCartView();

        // Make ShoppingCartView visible
        shoppingCartView.setVisible(true);

        // Hide the current ProductView
        this.setVisible(false);
    }
	
	//Open HistoryView function
	private void openHistoryView() {
	    // Create an instance of HistoryView
	    HistoryView historyView = new HistoryView();

	    // Make HistoryView visible
	    historyView.setVisible(true);

	    // Hide the current ProductView
	    this.setVisible(false);
	}
}