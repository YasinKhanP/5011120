import java.util.Arrays;

public class EcommerceSearch {
    
    
    public static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters
        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        // Displays the product info
        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Using Linear search
    public static class LinearSearch {
        public static Product linearSearch(Product[] products, int targetId) {
            for (Product product : products) {
                if (product.getProductId() == targetId) {
                    return product;
                }
            }
            return null; 
        }
    }

    // using Binary Search
    public static class BinarySearch {
        public static Product binarySearch(Product[] products, int targetId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (products[mid].getProductId() == targetId) {
                    return products[mid];
                }
                if (products[mid].getProductId() < targetId) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null; 
        }

        // sorts by product id
        public static void sortProductsById(Product[] products) {
            Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));
        }
    }

    // for testing
    public static void main(String[] args) {
        // Create some sample products
        Product[] products = {
            new Product(3, "Product C", "Category 1"),
            new Product(1, "Product A", "Category 2"),
            new Product(2, "Product B", "Category 1")
        };

        // to test the implemented linear search
        System.out.println("Testing Linear Search:");
        Product resultLinear = LinearSearch.linearSearch(products, 2);
        if (resultLinear != null) {
            System.out.println("Found: " + resultLinear);
        } else {
            System.out.println("Product not found.");
        }

        // Sorting products from the Binary search
        System.out.println("\nSorting products for Binary Search...");
        BinarySearch.sortProductsById(products);

        // Evaluates the binary search performed
        System.out.println("\nTesting Binary Search:");
        Product resultBinary = BinarySearch.binarySearch(products, 2);
        if (resultBinary != null) {
            System.out.println("Found: " + resultBinary);
        } else {
            System.out.println("Product not found.");
        }
    }
}
