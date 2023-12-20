package commerce.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ShoppingCartView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel productNameLabel;
	private static JLabel productImageLabel;
	private static JLabel itemCountLabel;
	private static JLabel subtotalPriceLabel;
	
	private double productPrice = 0.0; // Initial with default value
	private int itemCount = 1; // Initial begin item count
	
    public void setProductName(String productName) {
        productNameLabel.setText(productName);
    }
    
    public void setProductImage(String imagePath) {
    	productImageLabel.setIcon(new ImageIcon(imagePath));
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartView frame = new ShoppingCartView();
					frame.setVisible(true);
					
					frame.addToCart("productName", 0.0);
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
		
		productImageLabel = new JLabel("");
		productImageLabel.setBounds(0, 0, 100, 104);
		panel.add(productImageLabel);
		
		productNameLabel = new JLabel("");
		productNameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		productNameLabel.setBounds(110, 25, 190, 14);
		panel.add(productNameLabel);
		
		itemCountLabel = new JLabel(Integer.toString(itemCount));
		itemCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itemCountLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemCountLabel.setBounds(159, 56, 31, 25);
		panel.add(itemCountLabel);
		
		JButton increaseButton = new JButton("+");
		increaseButton.setForeground(new Color(255, 255, 255));
		increaseButton.setBackground(new Color(239, 110, 32));
		increaseButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		increaseButton.setBounds(198, 56, 46, 25);
		increaseButton.addActionListener(e -> increaseItemCount());
		panel.add(increaseButton);
		
		JButton decreaseButton = new JButton("-");
		decreaseButton.setForeground(new Color(255, 255, 255));
		decreaseButton.setBackground(new Color(239, 110, 32));
		decreaseButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		decreaseButton.setBounds(103, 56, 46, 25);
		decreaseButton.addActionListener(e -> decreaseItemCount());
		panel.add(decreaseButton);
		
		subtotalPriceLabel = new JLabel("");
		subtotalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subtotalPriceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		subtotalPriceLabel.setBounds(416, 37, 190, 14);
		panel.add(subtotalPriceLabel);
		
		JLabel removeLabel = new JLabel("Remove");
		removeLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		removeLabel.setForeground(new Color(255, 0, 0));
		removeLabel.setBounds(560, 62, 46, 14);
		panel.add(removeLabel);
		
		JButton checkoutButton = new JButton("Check Out");
		checkoutButton.setBackground(new Color(239, 110, 32));
		checkoutButton.setForeground(new Color(255, 255, 255));
		checkoutButton.setBounds(537, 305, 100, 23);
		contentPane.add(checkoutButton);
		checkoutButton.addActionListener(e -> {
			dispose();
		});
		
		JLabel totalPrice = new JLabel("");
		totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPrice.setBounds(352, 271, 285, 23);
		contentPane.add(totalPrice);
		
		removeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeFromCart();
            }
        });
	}
	
	// Passing the productInfo from ProductView
	public void addToCart(String productName, double productPrice) {
		productNameLabel.setText(productName);
		this.productPrice = productPrice;
		updateSubtotalPriceLabel();
	}
	
	// Update subtotal price function
	private void updateSubtotalPriceLabel() {
	    double subtotal = itemCount * productPrice;
	    subtotalPriceLabel.setText("Subtotal: Rp " + String.format("%.2f", subtotal));
	}
	
	// Item count increase function
	private void increaseItemCount() {
        itemCount++;
        updateItemCountLabel();
        updateSubtotalPriceLabel();
    }
	
	// Item count decrease function
	private void decreaseItemCount() {
        if (itemCount > 1) {
            itemCount--;
            updateItemCountLabel();
            updateSubtotalPriceLabel();
        }
    }
	
//	private void updateSubtotal() {
//		double subtotal = productPrice * itemCount;
//		subtotalPriceLabel.setText(String.format("Subtotal: $%.2f", subtotal));
//	}
	
	// Update itemCount function
	private void updateItemCountLabel() {
        itemCountLabel.setText(Integer.toString(itemCount));
    }
	
	// Remove from cart function
	private void removeFromCart() {
        clearProductInfo();
        navigateToProductView();
    }

	// Clear product info function
    private void clearProductInfo() {
        productNameLabel.setText("");
        productImageLabel.setIcon(null);
        itemCount = 1; // Reset item count
        updateItemCountLabel();
    }

    // Move to ProductView function
    private void navigateToProductView() {
        ProductView productView = new ProductView();
        productView.setVisible(true);
        dispose();
    }
}





