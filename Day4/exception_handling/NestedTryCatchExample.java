package exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatchExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter the index to access: ");
            int index = scanner.nextInt();

            // Check for ArrayIndexOutOfBoundsException immediately after getting the index
            if (index < 0 || index >= arr.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid array index!");
            }

            System.out.print("Enter the divisor: ");
            int divisor = scanner.nextInt();

            try {
                int element = arr[index];
                try {
                    double result = (double) element / divisor;
                    System.out.println("Result of division: " + result);
                } catch (ArithmeticException e) {
                    System.err.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Invalid array index!");
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input format. Please enter integers.");
            scanner.next(); // Consume the invalid input
        } finally {
            scanner.close();
        }
    }
}