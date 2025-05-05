package hashmap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                String cleanedLine = line.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
                String[] words = cleanedLine.split("\\s+"); // Split by whitespace

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return wordFrequencies;
    }

    public static void main(String[] args) {
        String filePath = "D://EclipseDownload//Collections//src//sample.txt"; // Replace with the actual path to your text file

        // Create a sample.txt file for demonstration
        try {
            java.io.FileWriter writer = new java.io.FileWriter(filePath);
            writer.write("Hello world, hello Java! This is a sample text with some repeated words like hello and text.");
            writer.close();
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
            return;
        }

        Map<String, Integer> frequencyMap = countWordFrequency(filePath);

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}