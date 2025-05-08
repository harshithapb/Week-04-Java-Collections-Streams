package regex;

import java.util.Scanner;
public class ReplaceSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();
        String output = input.replaceAll("\\s+", " ");
        System.out.println(output);
    }
}

