package exception_handling;

public class InterestCalculator {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive.");
        }
        return amount * rate * years;
    }

    public static void main(String[] args) {
        double principal1 = 1000;
        double interestRate1 = 0.05;
        int time1 = 3;

        try {
            double interest1 = calculateInterest(principal1, interestRate1, time1);
            System.out.println("Interest for $" + principal1 + " at " + (interestRate1 * 100) + "% for " + time1 + " years: $" + interest1);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        double principal2 = -500;
        double interestRate2 = 0.07;
        int time2 = 2;

        try {
            double interest2 = calculateInterest(principal2, interestRate2, time2);
            System.out.println("Interest for $" + principal2 + " at " + (interestRate2 * 100) + "% for " + time2 + " years: $" + interest2);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        double principal3 = 1200;
        double interestRate3 = -0.02;
        int time3 = 5;

        try {
            double interest3 = calculateInterest(principal3, interestRate3, time3);
            System.out.println("Interest for $" + principal3 + " at " + (interestRate3 * 100) + "% for " + time3 + " years: $" + interest3);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
