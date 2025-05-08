package interface_pgms;

import java.util.Scanner;
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}
public class LambdaSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        Adder adder = (a, b) -> a + b;
        int result = adder.add(num1, num2);
        System.out.println("Sum: " + result);
    }
}

