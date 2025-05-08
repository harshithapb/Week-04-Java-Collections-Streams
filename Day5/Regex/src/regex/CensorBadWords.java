package regex;

import java.util.Scanner;
public class CensorBadWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String input = scanner.nextLine();
        System.out.print("Enter bad words separated by commas: ");
        String badWordsInput = scanner.nextLine();
        String[] badWords = badWordsInput.split(",");
        for (String word : badWords) {
            input = input.replaceAll("(?i)\\b" + word.trim() + "\\b", "****");
        }
        System.out.println(input);
    }
}

