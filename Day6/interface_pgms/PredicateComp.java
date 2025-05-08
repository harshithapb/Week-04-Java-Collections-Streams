package interface_pgms;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class PredicateComp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        System.out.println("Enter strings (type 'stop' to end):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) break;
            strings.add(input);
        }
        System.out.print("Enter substring to check: ");
        String keyword = scanner.nextLine();
        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;
        Predicate<String> containsKeyword = s -> s.contains(keyword);
        Predicate<String> combinedPredicate = lengthGreaterThanFive.and(containsKeyword);
        List<String> filtered = strings.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());
        System.out.println("Filtered Strings:");
        filtered.forEach(System.out::println);
    }
}

