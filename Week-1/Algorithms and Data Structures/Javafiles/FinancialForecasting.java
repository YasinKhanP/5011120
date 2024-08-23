// FinancialForecasting.java

public class FinancialForecasting {

    // Method to calculate future value using a recursive approach
    public static double calculateFutureValue(double principal, double rate, int years) {
        // Base case: if no more years are left, return the principal
        if (years == 0) {
            return principal;
        }
        // Recursive case: calculate future value for the next year
        return calculateFutureValue(principal * (1 + rate), rate, years - 1);
    }

    // Main method to test the functionality of the financial forecasting tool
    public static void main(String[] args) {
        double principal = 1000.0;  // Initial principal amount
        double rate = 0.05;         // Annual growth rate (5%)
        int years = 10;             // Number of years to predict

        // Calculate future value using the recursive method
        double futureValue = calculateFutureValue(principal, rate, years);

        // Print the calculated future value
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}

