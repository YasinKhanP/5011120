

public class SortingOrders {

    // Inner class Order
    static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        // Getters
        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        // toString Method
        @Override
        public String toString() {
            return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice;
        }
    }

    
    static class BubbleSort {
        public static void bubbleSort(Order[] orders) {
            int n = orders.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        // Swap orders[j] and orders[j + 1]
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                    }
                }
            }
        }
    }

    
    static class QuickSort {
        public static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);
                quickSort(orders, low, pi - 1);
                quickSort(orders, pi + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].getTotalPrice();
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() < pivot) {
                    i++;
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;
            return i + 1;
        }
    }

    
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Likey", 250.0),
            new Order(2, "Haasni", 150.0),
            new Order(3, "Kasi", 300.0),
            new Order(4, "Keerthy", 200.0)
        };

        // Prints original orders
        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Bubble Sort
        System.out.println("\nOrders Sorted by Bubble Sort:");
        BubbleSort.bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reset orders
        orders = new Order[]{
            new Order(1, "Likey", 250.0),
            new Order(2, "Haasni", 150.0),
            new Order(3, "kasi", 300.0),
            new Order(4, "keerthy", 200.0)
        };

        // Quick Sort
        System.out.println("\nOrders Sorted by Quick Sort:");
        QuickSort.quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
