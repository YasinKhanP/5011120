public class ProxyPatternExample {

    // Subject Interface: Image
    public interface Image {
        void display();
    }

    // Real Subject Class: RealImage
    public static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadImageFromServer();
        }

        private void loadImageFromServer() {
            // Simulate loading image from a remote server
            System.out.println("Loading image: " + filename);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Proxy Class: ProxyImage
    public static class ProxyImage implements Image {
        private RealImage realImage;
        private String filename;
        private boolean isLoaded = false;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (!isLoaded) {
                realImage = new RealImage(filename);
                isLoaded = true;
            }
            realImage.display();
        }
    }

    // Test Class to demonstrate Proxy Pattern
    public static class ProxyPatternTest {
        public static void main(String[] args) {
            // Create proxy images
            Image image1 = new ProxyImage("image1.jpg");
            Image image2 = new ProxyImage("image2.jpg");

            // Display images
            System.out.println("First display call for image1:");
            image1.display(); // RealImage should be loaded and displayed

            System.out.println("\nSecond display call for image1:");
            image1.display(); // Should use cached RealImage

            System.out.println("\nFirst display call for image2:");
            image2.display(); // RealImage should be loaded and displayed

            System.out.println("\nSecond display call for image2:");
            image2.display(); // Should use cached RealImage
        }
    }
}
