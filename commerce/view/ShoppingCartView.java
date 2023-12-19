package commerce.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ShoppingCartView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartView frame = new ShoppingCartView();
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
	public ShoppingCartView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shopping Cart");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 11, 100, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Remove All");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(574, 13, 63, 16);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 41, 616, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel productImage = new JLabel("");
		productImage.setBounds(0, 0, 100, 104);
		panel.add(productImage);
		
		JLabel productName = new JLabel("");
		productName.setFont(new Font("SansSerif", Font.BOLD, 14));
		productName.setBounds(110, 25, 190, 14);
		panel.add(productName);
		
		JButton increaseButton = new JButton("+");
		increaseButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		increaseButton.setBounds(201, 56, 43, 25);
		panel.add(increaseButton);
		
		JButton decreaseButton = new JButton("-");
		decreaseButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		decreaseButton.setBounds(110, 56, 39, 25);
		panel.add(decreaseButton);
		
		JLabel itemCount = new JLabel("");
		itemCount.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemCount.setBounds(159, 56, 31, 25);
		panel.add(itemCount);
		
		JLabel subtotalPriceLabel = new JLabel("");
		subtotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subtotalPriceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		subtotalPriceLabel.setBounds(416, 37, 190, 14);
		panel.add(subtotalPriceLabel);
		
		JLabel removeLabel = new JLabel("Remove");
		removeLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		removeLabel.setForeground(new Color(255, 0, 0));
		removeLabel.setBounds(560, 62, 46, 14);
		panel.add(removeLabel);
	}
}
