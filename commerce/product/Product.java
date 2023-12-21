package commerce.product;

import commerce.manager.ProductManager;

public class Product {
    private String name;
    private String imagePath;
    private int id;

    public Product(String name, String imagePath, int id) {
        this.name = name;
        this.imagePath = imagePath;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
    
    public int getId() {
    	return id;
    }
}








