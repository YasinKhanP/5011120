public class AdapterPatternExample {

    // Target Interface: PaymentProcessor
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee Classes with their own methods
    public static class Paypal {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    public static class Stripe {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " using Stripe.");
        }
    }

    // Adapter for PayPal
    public static class PaypalAdapter implements PaymentProcessor {
        private Paypal paypal;

        public PaypalAdapter(Paypal paypal) {
            this.paypal = paypal;
        }

        @Override
        public void processPayment(double amount) {
            paypal.makePayment(amount);
        }
    }

    // Adapter for Stripe
    public static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.charge(amount);
        }
    }

    // Test class to demonstrate Adapter Pattern
    public static class AdapterPatternTest {
        public static void main(String[] args) {
            // Create instances of the payment gateways
            Paypal paypal = new Paypal();
            Stripe stripe = new Stripe();

            // Wrap them in adapters
            PaymentProcessor paypalProcessor = new PaypalAdapter(paypal);
            PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

            // Use the adapters to process payments
            paypalProcessor.processPayment(150.00);
            stripeProcessor.processPayment(200.00);
        }
    }
}
