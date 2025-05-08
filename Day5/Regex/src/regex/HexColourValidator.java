package regex;

import java.util.Scanner;
import java.util.regex.*;
public class HexColourValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hex color code: ");
        String color = scanner.nextLine();
        String regex = "^#[0-9a-fA-F]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        if (matcher.matches()) {
            System.out.println("Valid hex color code");
        } else {
            System.out.println("Invalid hex color code");
        }
    }
}

