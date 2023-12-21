package commerce.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commerce.manager.AuthenticationManager;
import commerce.manager.ProductManager;
import commerce.product.Product;
import commerce.user.User;
import commerce.login.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private JLabel balanceLabel;
	
	private double productPrice = 0.0; // Initial with default value
	private int itemCount = 1; // Initial begin item count
	
    public void setProductName(String productName) {
        productNameLabel.setText(productName);
    }
    
    public void setProductImage(String imagePath) {
    	productImageLabel.setIcon(new ImageIcon(imagePath));
    }
    
    public void setBalance(double balance) {
        // Your logic to display or update the balance in the view
        // For example, if you have a JLabel to display the balance:
        balanceLabel.setText("Balance: Rp " + balance);
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
					
					frame.addToCart("productName", 0.0, 1);
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
            performCheckout();
//            JOptionPane.showMessageDialog(this, "Checkout successful!");
            navigateToProductView();
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
        
        balanceLabel = new JLabel("Balance: Rp 0.0"); // You can set an initial value
        balanceLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        balanceLabel.setBounds(21, 305, 150, 23);
        contentPane.add(balanceLabel);
    }

    // Passing the productInfo from ProductView
    public void addToCart(String productName, double productPrice, int productId) {
        Product product = new Product(productName, "", productId); // Replace with actual product information
        ProductManager.setSelectedProduct(product);
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

    private void performCheckout() {
        User loggedInUser = AuthenticationManager.getLoggedInUser();
        if (loggedInUser == null) {
            JOptionPane.showMessageDialog(this, "Please log in before checking out.");
            return; // Abort the checkout process
        }

        Product selectedProduct = ProductManager.getSelectedProduct();
        if (selectedProduct == null) {
            JOptionPane.showMessageDialog(this, "Please select a product before checking out.");
            return; // Abort the checkout process
        }

        int userId = loggedInUser.getId();
        int productId = ProductManager.getSelectedProduct().getId();

        double productPrice = getProductPrice(productId);
        int itemCount = this.itemCount;
        
        String productName = selectedProduct.getName();
        double totalPrice = itemCount * productPrice;

        
        // Update purchase history in HistoryView
        HistoryView historyView = new HistoryView();
        historyView.updatePurchaseHistory(productName, itemCount, totalPrice);
        historyView.setVisible(true);

        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/account_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Insert the order into the database
            String insertOrderQuery = "INSERT INTO cart_tbl (id_user, id_produk, quantity) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertOrderQuery)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, productId);
                preparedStatement.setInt(3, itemCount);
                preparedStatement.executeUpdate();
            }

            decreaseProductAmount(productId, itemCount);

            // Clear product information after checkout
            clearProductInfo();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private double getProductPrice(int productId) {
        double productPrice = 0.0;
        String jdbcUrl = "jdbc:mysql://localhost:3306/account_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT harga_barang FROM produk_tbl WHERE id_barang = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, productId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        productPrice = resultSet.getDouble("harga_barang");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productPrice;
    }
    
    private boolean hasEnoughStock(int productId, int requestedQuantity) {
        int availableStock = getProductStock(productId);
        return availableStock >= requestedQuantity;
    }

    private int getProductStock(int productId) {
        int stock = 0;
        String jdbcUrl = "jdbc:mysql://localhost:3306/account_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT stok_barang FROM produk_tbl WHERE id_barang = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, productId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        stock = resultSet.getInt("stok_barang");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stock;
    }

    private void decreaseProductAmount(int productId, int quantity) {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/account_db";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Update the product stock in produk_tbl
            String updateProductQuery = "UPDATE produk_tbl SET stok_barang = stok_barang - ? WHERE id_barang = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateProductQuery)) {
                preparedStatement.setInt(1, quantity);
                preparedStatement.setInt(2, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
}





