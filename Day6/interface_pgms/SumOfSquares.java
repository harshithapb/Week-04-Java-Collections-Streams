package interface_pgms;

import java.util.*;
import java.util.stream.*;
public class SumOfSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }
        int sumOfSquares = numbers.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
