package regex;

import java.util.Scanner;
import java.util.regex.*;
public class LicensePlateValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate number: ");
        String plate = scanner.nextLine();
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        if (matcher.matches()) {
            System.out.println("Valid license plate number");
        } else {
            System.out.println("Invalid license plate number");
        }
    }
}

