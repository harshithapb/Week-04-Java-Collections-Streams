package regex;

import java.util.Scanner;
import java.util.regex.*;
import java.util.HashSet;
import java.util.Set;
public class RepeatingWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        Set<String> repeatingWords = new HashSet<>();
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1).toLowerCase());
        }
        System.out.println("Repeating words: " + String.join(", ", repeatingWords));
    }
}

