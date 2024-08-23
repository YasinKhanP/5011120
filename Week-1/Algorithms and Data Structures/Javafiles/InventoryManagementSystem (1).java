import java.util.HashMap;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

public class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product ID " + product.getProductId() + " already exists. Use updateProduct to update it.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product " + product.getProductName() + " added to inventory.");
        }
    }

    public void updateProduct(int productId, Integer quantity, Double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            if (quantity != null) {
                product.setQuantity(quantity);
            }
            if (price != null) {
                product.setPrice(price);
            }
            System.out.println("Product ID " + productId + " updated.");
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product ID " + productId + " deleted.");
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        // Create an inventory management system
        InventoryManagementSystem ims = new InventoryManagementSystem();

        // Add products
        Product p1 = new Product(1, "Bluetooth", 10, 999.99);
        Product p2 = new Product(2, "vivo-1729", 1, 19999.99);
        ims.addProduct(p1);
        ims.addProduct(p2);

        // Print inventory
        ims.printInventory();

        // TO Update a product
        ims.updateProduct(1, 2, null);
        ims.updateProduct(2, null, 17888.99);

        // To print an created inventory
        ims.printInventory();

        // To Delete a product 
        ims.deleteProduct(1);

        // Prints after deletion
        ims.printInventory();
    }
}
