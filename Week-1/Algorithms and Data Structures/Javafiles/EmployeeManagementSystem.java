// EmployeeManagementSystem.java

public class EmployeeManagementSystem {

    // Inner class Employee to represent each employee's record
    static class Employee {
        private int employeeId;  // Unique identifier for the employee
        private String name;     // Name of the employee
        private String position; // Position of the employee in the company
        private double salary;   // Salary of the employee

        // Constructor to initialize an Employee object with specified details
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getter method for employee ID
        public int getEmployeeId() {
            return employeeId;
        }

        // Getter method for employee name
        public String getName() {
            return name;
        }

        // Getter method for employee position
        public String getPosition() {
            return position;
        }

        // Getter method for employee salary
        public double getSalary() {
            return salary;
        }

        // toString method to return a string representation of the Employee object
        @Override
        public String toString() {
            return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
        }
    }

    // Inner class EmployeeManager to manage employee records
    static class EmployeeManager {
        private Employee[] employees; // Array to store employee records
        private int size; // Number of employees currently in the array

        // Constructor to initialize the EmployeeManager with a specified capacity
        public EmployeeManager(int capacity) {
            employees = new Employee[capacity]; // Create an array with the given capacity
            size = 0; // Initialize size to 0 as no employees are added yet
        }

        // Method to add a new employee to the array
        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size++] = employee; // Add the employee to the array and increment the size
            } else {
                System.out.println("Array is full, cannot add more employees."); // Inform if the array is full
            }
        }

        // Method to search for an employee by their ID
        public Employee searchEmployee(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    return employees[i]; // Return the employee if the ID matches
                }
            }
            return null; // Return null if the employee with the given ID is not found
        }

        // Method to traverse and print all employee records
        public void traverseEmployees() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]); // Print each employee's details
            }
        }

        // Method to delete an employee by their ID
        public boolean deleteEmployee(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    // Shift all elements to the left to fill the gap left by the deleted employee
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[size - 1] = null; // Nullify the last element after shifting
                    size--; // Decrement the size of the array
                    return true; // Return true indicating the employee was successfully deleted
                }
            }
            return false; // Return false if the employee with the given ID is not found
        }
    }

    // Main method to test the functionality of the employee management system
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5); // Create an EmployeeManager with capacity for 5 employees

        // Add employees to the manager
        manager.addEmployee(new Employee(1, "Keerthi", "Developer", 70000));
        manager.addEmployee(new Employee(2, "Kasi", "Designer", 65000));
        manager.addEmployee(new Employee(3, "Likey", "Manager", 80000));
        manager.addEmployee(new Employee(4, "Haasni", "Analyst", 60000));

        // Print all employees currently in the system
        System.out.println("All Employees:");
        manager.traverseEmployees();

        // Search for an employee with ID 2 and print their details
        Employee emp = manager.searchEmployee(2);
        System.out.println("\nSearch Result:");
        if (emp != null) {
            System.out.println(emp); // Print the details of the employee if found
        } else {
            System.out.println("Employee not found."); // Inform if the employee is not found
        }

        // Delete an employee with ID 2 and provide feedback on the deletion operation
        System.out.println("\nDeleting Employee with ID 2:");
        boolean deleted = manager.deleteEmployee(2);
        if (deleted) {
            System.out.println("Employee deleted successfully."); // Confirm deletion
        } else {
            System.out.println("Employee not found."); // Inform if the employee was not found
        }

        // Print all employees after deletion to show the updated list
        System.out.println("\nAll Employees After Deletion:");
        manager.traverseEmployees();
    }
}

