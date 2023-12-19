package commerce.cart;

public class ShoppingCartItem {
    private String productName;
    private int quantity;

    public ShoppingCartItem(String productName) {
        this.productName = productName;
        this.quantity = 1;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public double getItemPrice() {
        return 10.0;
    }

    public double getSubtotal() {
        return quantity * getItemPrice();
    }
}













