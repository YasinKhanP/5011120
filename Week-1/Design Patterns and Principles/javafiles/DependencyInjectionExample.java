// DependencyInjectionExample.java

public class DependencyInjectionExample {

    // Step 2: Define Repository Interface
    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    // Step 3: Implement Concrete Repository
    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Simulate fetching customer from a data source
            return new Customer(id, "yasin");
        }
    }

    // Define a simple Customer class
    static class Customer {
        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    // Step 4: Define Service Class
    static class CustomerService {
        private CustomerRepository customerRepository;

        // Step 5: Implement Dependency Injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer findCustomerById(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

    // Step 6: Test the Dependency Injection Implementation
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.findCustomerById(1);

        // Display customer details
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Name: " + customer.getName());
    }
}