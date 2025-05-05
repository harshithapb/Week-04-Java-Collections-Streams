package QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class GenerateBinary {

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1"); // The first binary number

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);

            // Generate the next two binary numbers by appending '0' and '1'
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaryNumbers = generateBinary(n);
        System.out.println("First " + n + " binary numbers:");
        System.out.println(binaryNumbers);

        int m = 10;
        List<String> firstTen = generateBinary(m);
        System.out.println("\nFirst " + m + " binary numbers:");
        System.out.println(firstTen);
    }
}