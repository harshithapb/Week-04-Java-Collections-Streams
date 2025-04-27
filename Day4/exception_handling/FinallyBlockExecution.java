package exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlockExecution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = 0;
        int denominator = 0;
        double result = 0;

        try {
            System.out.print("Enter the numerator: ");
            numerator = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            denominator = scanner.nextInt();

            if (denominator == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            result = (double) numerator / denominator;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter integers only.");
            scanner.next(); // Consume the invalid input
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}