package regex;

import java.util.*;
import java.util.regex.*;
public class Lang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust|TypeScript)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
