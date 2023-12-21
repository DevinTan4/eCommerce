package commerce.manager;

import commerce.product.Product;

public class ProductManager {
	private static Product selectedProduct;

    public static void setSelectedProduct(Product product) {
        selectedProduct = product;
    }

    public static Product getSelectedProduct() {
        return selectedProduct;
    }
    
    public static void clearSelectedProduct() {
        selectedProduct = null;
    }
}
