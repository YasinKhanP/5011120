// StrategyPatternExample.java
public class StrategyPatternExample {

    // Step 2: Define Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Step 3: Implement Concrete Strategies
    static class CreditCardPayment implements PaymentStrategy {
        private String name;
        private String cardNumber;
        private String cvv;
        private String dateOfExpiry;

        public CreditCardPayment(String nm, String ccNum, String cvv, String expiryDate) {
            this.name = nm;
            this.cardNumber = ccNum;
            this.cvv = cvv;
            this.dateOfExpiry = expiryDate;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid with credit card.");
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String emailId;
        private String password;

        public PayPalPayment(String email, String pwd) {
            this.emailId = email;
            this.password = pwd;
        }

        @Override
        public void pay(int amount) {
            System.out.println(amount + " paid using PayPal.");
        }
    }

    // Step 4: Implement Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(int amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Step 5: Test the Strategy Implementation
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with credit card
        PaymentStrategy creditCardPayment = new CreditCardPayment("John Doe", "1234567890123456", "786", "12/23");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(100);

        // Paying with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "mypassword");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(200);
    }
}