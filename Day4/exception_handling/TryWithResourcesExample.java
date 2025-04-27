package exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourcesExample {

    public static void main(String[] args) {
        String filename = "info.txt";

        // Create a dummy info.txt file for testing
        try {
            Files.writeString(Paths.get(filename), "This is the first line of the info file.\nThis is the second line.");
        } catch (IOException e) {
            System.err.println("Error creating dummy file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line of " + filename + ": " + firstLine);
            } else {
                System.out.println(filename + " is empty.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            System.out.println("(Cleanup handled automatically by try-with-resources)");
        }

        // Test case where the file does not exist
        String nonExistingFile = "non_existent_info.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(nonExistingFile))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line of " + nonExistingFile + ": " + firstLine);
            } else {
                System.out.println(nonExistingFile + " is empty.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}