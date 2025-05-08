package regex;

import java.util.Scanner;
import java.util.regex.*;
public class IPAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter IP address: ");
        String ip = scanner.nextLine();
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }
    }
}

