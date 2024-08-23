// TaskManagementSystem.java

public class TaskManagementSystem {

    // Inner class Task to represent each task's record
    static class Task {
        private int taskId;       // Unique identifier for the task
        private String taskName;  // Name or description of the task
        private String status;    // Status of the task (e.g., pending, completed)

        // Constructor to initialize a Task object with specified details
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        // Getter method for task ID
        public int getTaskId() {
            return taskId;
        }

        // Getter method for task name
        public String getTaskName() {
            return taskName;
        }

        // Getter method for task status
        public String getStatus() {
            return status;
        }

        // toString method to return a string representation of the Task object
        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    // Node class for singly linked list
    static class Node {
        Task task; // The task data stored in this node
        Node next; // Reference to the next node in the list

        // Constructor to initialize a Node with a task
        public Node(Task task) {
            this.task = task;
            this.next = null; // Next is initially null
        }
    }

    // SinglyLinkedList class to manage the linked list of tasks
    static class SinglyLinkedList {
        private Node head; // Head of the linked list

        // Method to add a new task to the list
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode; // If the list is empty, set new node as head
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next; // Traverse to the end of the list
                }
                current.next = newNode; // Add new node at the end
            }
        }

        // Method to search for a task by its ID
        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task; // Return the task if the ID matches
                }
                current = current.next; // Move to the next node
            }
            return null; // Return null if the task is not found
        }

        // Method to traverse and print all tasks in the list
        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task); // Print each task's details
                current = current.next; // Move to the next node
            }
        }

        // Method to delete a task by its ID
        public boolean deleteTask(int taskId) {
            if (head == null) {
                return false; // List is empty, nothing to delete
            }

            if (head.task.getTaskId() == taskId) {
                head = head.next; // If the head needs to be deleted, move head to the next node
                return true;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.task.getTaskId() == taskId) {
                    current.next = current.next.next; // Bypass the node to be deleted
                    return true;
                }
                current = current.next; // Move to the next node
            }
            return false; // Task with the given ID was not found
        }
    }

    // Main method to test the functionality of the task management system
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList(); // Create an instance of SinglyLinkedList

        // Add tasks to the task list
        taskList.addTask(new Task(1, "Design database schema", "pending"));
        taskList.addTask(new Task(2, "Develop API", "in progress"));
        taskList.addTask(new Task(3, "Create UI mockups", "completed"));
        taskList.addTask(new Task(4, "Conduct user testing", "pending"));

        // Print all tasks currently in the system
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task with ID 2 and print its details
        Task task = taskList.searchTask(2);
        System.out.println("\nSearch Result:");
        if (task != null) {
            System.out.println(task); // Print the details of the task if found
        } else {
            System.out.println("Task not found."); // Inform if the task is not found
        }

        // Delete a task with ID 2 and provide feedback on the deletion operation
        System.out.println("\nDeleting Task with ID 2:");
        boolean deleted = taskList.deleteTask(2);
        if (deleted) {
            System.out.println("Task deleted successfully."); // Confirm deletion
        } else {
            System.out.println("Task not found."); // Inform if the task was not found
        }

        // Print all tasks after deletion to show the updated list
        System.out.println("\nAll Tasks After Deletion:");
        taskList.traverseTasks();
    }
}

