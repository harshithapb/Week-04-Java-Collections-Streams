package interface_pgms;

import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
interface FrequentWordFinder2 {
    Map<String, Integer> getWordFrequencies(String text);
    List<Map.Entry<String, Integer>> findTopNWords(String text, int n);
    void displayTopNWords(List<Map.Entry<String, Integer>> topNWords);
    String findSecondMostFrequentWord(String text); // New method
}

public class DefaultFrequentWordFinder2 implements FrequentWordFinder2 {

    @Override
    public Map<String, Integer> getWordFrequencies(String text) {
        if (text == null || text.isEmpty()) {
            return new HashMap<>();
        }

        // Tokenize the text: lowercase and remove punctuation
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text.toLowerCase());
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }

        // Count word frequencies using streams
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().intValue()));
    }

    @Override
    public List<Map.Entry<String, Integer>> findTopNWords(String text, int n) {
        Map<String, Integer> wordFrequencies = getWordFrequencies(text);

        return wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public void displayTopNWords(List<Map.Entry<String, Integer>> topNWords) {
        if (topNWords.isEmpty()) {
            System.out.println("No words found.");
            return;
        }
        System.out.println("Top " + topNWords.size() + " most frequent words:");
        for (Map.Entry<String, Integer> entry : topNWords) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Override
    public String findSecondMostFrequentWord(String text) {
        Map<String, Integer> wordFrequencies = getWordFrequencies(text);

        if (wordFrequencies.size() < 2) {
            return "Not enough unique words to find the second most frequent.";
        }

        return wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .skip(1) // Skip the most frequent word
                .findFirst() // Get the second most frequent
                .map(Map.Entry::getKey) // Extract the word
                .orElse("No second most frequent word found.");
    }

    public static void main(String[] args) {
        String wordSequence = "the quick brown fox jumps over the lazy fox the quick brown the";
        FrequentWordFinder wordFinder = new DefaultFrequentWordFinder();

        String secondMostFrequent = wordFinder.findSecondMostFrequentWord(wordSequence);
        System.out.println("Second most frequent word: " + secondMostFrequent);
    }
}
