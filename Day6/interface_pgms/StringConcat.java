package interface_pgms;

import java.util.Scanner;
import java.util.function.BiFunction;
public class StringConcat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter str1: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter str2: ");
        String str2 = scanner.nextLine();
        BiFunction<String, String, String> concatFunction = (s1, s2) -> s1 + " " + s2;
        String result = concatFunction.apply(str1, str2);
        System.out.println("Concatenated String: " + result);
    }
}

