public class SingletonPatternExample {

    // Singleton Logger class
    public static class Logger {
        // Step 1: Create a private static instance of the Logger class.
        private static Logger instance;

        // Step 2: Make the constructor private to prevent instantiation from other classes.
        private Logger() {
            // Initialization code, if needed
        }

        // Step 3: Provide a public static method to get the instance of the Logger class.
        public static Logger getInstance() {
            if (instance == null) {
                // Synchronized block to prevent race conditions in multi-threaded environments.
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }

        // Example method to demonstrate logging
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Test class to verify Singleton implementation
    public static class SingletonTest {
        public static void main(String[] args) {
            // Get the first instance of Logger
            Logger logger1 = Logger.getInstance();
            // Get the second instance of Logger
            Logger logger2 = Logger.getInstance();

            // Print out the instances to verify they are the same
            System.out.println("Logger1 hashcode: " + logger1.hashCode());
            System.out.println("Logger2 hashcode: " + logger2.hashCode());

            // Test the logging method
            logger1.log("This is a test message.");
            logger2.log("This is another test message.");

            // Check if both instances are the same
            if (logger1 == logger2) {
                System.out.println("Logger instances are the same.");
            } else {
                System.out.println("Logger instances are different.");
            }
        }
    }
}
