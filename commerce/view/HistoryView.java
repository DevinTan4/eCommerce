package commerce.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import commerce.product.Product;
import commerce.user.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HistoryView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable historyTable;
    private DefaultTableModel model;
    
    // Labels to display product information
    private JLabel productNameLabel;
    private JLabel quantityLabel;
    private JLabel totalPriceLabel;
    
    private User loggedInUser;
    private Product selectedProduct;
    private int itemCount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HistoryView frame = new HistoryView();
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
    public HistoryView() {
    	
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 663, 338);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Labels to display product information
        productNameLabel = new JLabel("Product Name: ");
        quantityLabel = new JLabel("Quantity: ");
        totalPriceLabel = new JLabel("Total Price: ");
        
        // Add labels to a panel
        JPanel productInfoPanel = new JPanel();
        productInfoPanel.add(productNameLabel);
        productInfoPanel.add(quantityLabel);
        productInfoPanel.add(totalPriceLabel);
        
        // Add productInfoPanel to the contentPane
        contentPane.add(productInfoPanel, BorderLayout.NORTH);

        historyTable = new JTable();
        contentPane.add(new JScrollPane(historyTable), BorderLayout.CENTER);
        
//        insertPurchaseHistory(loggedInUser.getId(), selectedProduct.getId(), itemCount);

        fetchAndDisplayPurchaseHistory();
    }
    
    // Method to update product information labels
    private void updateProductInfoLabels(String productName, int quantity, double totalPrice) {
        productNameLabel.setText("Product Name: " + productName);
        quantityLabel.setText("Quantity: " + quantity);
        totalPriceLabel.setText("Total Price: " + totalPrice);
    }

    // Method to update purchase history after checkout
    public void updatePurchaseHistory(String productName, int quantity, double totalPrice) {
        DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
        model.addRow(new Object[]{productName, quantity, totalPrice});

        // Update product information labels
        updateProductInfoLabels(productName, quantity, totalPrice);
        
        setVisible(true);
    }

    private void fetchAndDisplayPurchaseHistory() {
        try {
            // Establish database connection
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/account_db", "root", "");
                 Statement statement = connection.createStatement()) {

                // Fetch purchase history from cart_tbl
                String query = "SELECT produk_tbl.nama_barang, cart_tbl.quantity, produk_tbl.harga_barang " +
                        "FROM cart_tbl " +
                        "INNER JOIN produk_tbl ON cart_tbl.id_produk = produk_tbl.id_barang " +
                        "WHERE cart_tbl.id_user = 1";  // Assuming 1 is the id_user for the logged-in user

                try (ResultSet resultSet = statement.executeQuery(query)) {
                    // Populate JTable with the fetched data
                    if (model == null) {
                        model = new DefaultTableModel();
                        model.addColumn("Product Name");
                        model.addColumn("Quantity");
                        model.addColumn("Total Price");
                        historyTable.setModel(model);
                    }

                    // Remove existing rows
                    model.setRowCount(0);

                    while (resultSet.next()) {
                        String productName = resultSet.getString("nama_barang");
                        int quantity = resultSet.getInt("quantity");
                        double totalPrice = resultSet.getDouble("harga_barang") * quantity;

                        model.addRow(new Object[]{productName, quantity, totalPrice});

                        // Update product information labels
                        updateProductInfoLabels(productName, quantity, totalPrice);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }
    
    private void insertPurchaseHistory(int userId, int productId, int quantity) {
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
                preparedStatement.setInt(3, quantity);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





