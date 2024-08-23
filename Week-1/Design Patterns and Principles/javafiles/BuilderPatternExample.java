public class BuilderPatternExample {

    // Product Class: Computer
    public static class Computer {
        private final String CPU;
        private final int RAM;
        private final int Storage;
        private final boolean isGraphicsCardIncluded;
        private final boolean isBluetoothIncluded;

        // Private constructor to enforce the use of the Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.isGraphicsCardIncluded = builder.isGraphicsCardIncluded;
            this.isBluetoothIncluded = builder.isBluetoothIncluded;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    "CPU='" + CPU + '\'' +
                    ", RAM=" + RAM +
                    "GB, Storage=" + Storage +
                    "GB, Graphics Card Included=" + isGraphicsCardIncluded +
                    ", Bluetooth Included=" + isBluetoothIncluded +
                    '}';
        }

        // Static nested Builder class
        public static class Builder {
            private String CPU;
            private int RAM;
            private int Storage;
            private boolean isGraphicsCardIncluded;
            private boolean isBluetoothIncluded;

            // Setters for each attribute with return type Builder
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(int RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(int Storage) {
                this.Storage = Storage;
                return this;
            }

            public Builder setGraphicsCardIncluded(boolean isGraphicsCardIncluded) {
                this.isGraphicsCardIncluded = isGraphicsCardIncluded;
                return this;
            }

            public Builder setBluetoothIncluded(boolean isBluetoothIncluded) {
                this.isBluetoothIncluded = isBluetoothIncluded;
                return this;
            }

            // Build method to create an instance of Computer
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Test class to demonstrate the Builder Pattern
    public static class BuilderPatternTest {
        public static void main(String[] args) {
            // Build a Computer with specific configuration
            Computer gamingComputer = new Computer.Builder()
                    .setCPU("Intel Core i9")
                    .setRAM(32)
                    .setStorage(1_000)
                    .setGraphicsCardIncluded(true)
                    .setBluetoothIncluded(true)
                    .build();

            // Build another Computer with a different configuration
            Computer officeComputer = new Computer.Builder()
                    .setCPU("Intel Core i5")
                    .setRAM(16)
                    .setStorage(500)
                    .setGraphicsCardIncluded(false)
                    .setBluetoothIncluded(false)
                    .build();

            // Print the configurations
            System.out.println("Gaming Computer: " + gamingComputer);
            System.out.println("Office Computer: " + officeComputer);
        }
    }
}
