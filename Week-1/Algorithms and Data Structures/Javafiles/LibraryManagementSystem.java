// LibraryManagementSystem.java

public class LibraryManagementSystem {

    // Inner class Book to represent each book's record
    static class Book {
        private int bookId;       // Unique identifier for the book
        private String title;     // Title of the book
        private String author;    // Author of the book

        // Constructor to initialize a Book object with specified details
        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        // Getter method for book title
        public String getTitle() {
            return title;
        }

        // Getter method for book author
        public String getAuthor() {
            return author;
        }

        // toString method to return a string representation of the Book object
        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Method to perform linear search to find books by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book; // Return the book if the title matches
            }
        }
        return null; // Return null if the book is not found
    }

    // Method to perform binary search to find books by title (assuming the list is sorted)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Return the book if the title matches
            } else if (comparison < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return null; // Return null if the book is not found
    }

    // Main method to test the functionality of the library management system
    public static void main(String[] args) {
        Book[] books = new Book[] {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Pride and Prejudice", "Jane Austen"),
            new Book(5, "The Catcher in the Rye", "J.D. Salinger")
        };

        // Perform linear search for a book by title
        String searchTitle1 = "1984";
        Book foundBook1 = linearSearch(books, searchTitle1);
        System.out.println("Linear Search Result:");
        if (foundBook1 != null) {
            System.out.println(foundBook1); // Print the details of the book if found
        } else {
            System.out.println("Book not found."); // Inform if the book is not found
        }

        // Sort books array by title for binary search
        java.util.Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Perform binary search for a book by title
        String searchTitle2 = "Pride and Prejudice";
        Book foundBook2 = binarySearch(books, searchTitle2);
        System.out.println("\nBinary Search Result:");
        if (foundBook2 != null) {
            System.out.println(foundBook2); // Print the details of the book if found
        } else {
            System.out.println("Book not found."); // Inform if the book is not found
        }
    }
}
