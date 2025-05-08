package interface_pgms;

import java.util.*;
import java.util.stream.Collectors;
public class FilterStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(scanner.nextLine());
        }
        List<String> filteredNames = names.stream()
                .filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filteredNames);
    }
}

