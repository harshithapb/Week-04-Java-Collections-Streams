package regex;

import java.util.Scanner;
import java.util.regex.*;
public class CapitalizedExtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String input = scanner.nextLine();
        String regex = "\\b[A-Z][a-zA-Z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

