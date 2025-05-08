package regex;

import java.util.Scanner;
import java.util.regex.*;
public class SSNValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = scanner.nextLine();
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid");
        }
        Pattern allNumbers = Pattern.compile("\\b\\d{9}\\b");
        Matcher m2 = allNumbers.matcher(input);
        while (m2.find()) {
            System.out.println("\"" + m2.group() + "\" is invalid");
        }
    }
}

