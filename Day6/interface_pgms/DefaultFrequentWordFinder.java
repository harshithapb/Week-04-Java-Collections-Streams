package interface_pgms;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Map;

interface FrequentWordFinder {
    Map<String, Integer> getWordFrequencies(String text);
    List<Map.Entry<String, Integer>> findTopNWords(String text, int n);
    void displayTopNWords(List<Map.Entry<String, Integer>> topNWords);
}
class DefaultFrequentWordFinder implements FrequentWordFinder {

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

        // Sort entries by frequency in descending order
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

    public static void main(String[] args) {
        String textCorpus = "This is a sample text corpus. This corpus contains several words, some words are repeated. Repeated words are important to count. This is it.";
        int topN = 5;

        FrequentWordFinder wordFinder = new DefaultFrequentWordFinder();
        List<Map.Entry<String, Integer>> topWords = wordFinder.findTopNWords(textCorpus, topN);
        wordFinder.displayTopNWords(topWords);
    }
}