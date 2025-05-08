package regex;

import java.util.Scanner;
import java.util.regex.*;
public class CreditCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();
        String regex = "^(4\\d{15}|5\\d{15})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);
        if (matcher.matches()) {
            if (cardNumber.startsWith("4"))
                System.out.println("Valid Visa card");
            else
                System.out.println("Valid MasterCard");
        } else {
            System.out.println("Invalid card number");
        }
    }
}
