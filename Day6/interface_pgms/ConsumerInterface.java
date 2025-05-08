package interface_pgms;

import java.util.*;
import java.util.function.Consumer;
public class ConsumerInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        System.out.println("Enter strings (type 'stop' to end):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) break;
            strings.add(input);
        }
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        strings.forEach(printUpperCase);
    }
}
