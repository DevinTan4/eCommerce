package commerce.cart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(String productName) {
        items.computeIfPresent(productName, (name, item) -> {
            item.increaseQuantity();
            return item;
        });

        items.putIfAbsent(productName, new ShoppingCartItem(productName));
    }

    public void removeItem(String productName) {
        items.remove(productName);
    }

    public Map<String, ShoppingCartItem> getItems() {
        return items;
    }
}






