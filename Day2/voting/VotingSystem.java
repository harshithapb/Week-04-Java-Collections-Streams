package voting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {

    private Map<String, Integer> votes = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.size() + 1); // Maintain order of votes
    }

    public Map<String, Integer> getVoteCounts() {
        return new HashMap<>(votes); // Return a copy to prevent external modification
    }

    public Map<String, Integer> getVoteOrder() {
        return new LinkedHashMap<>(voteOrder); // Return a copy
    }

    public void displayResultsSorted() {
        // Use TreeMap to sort results by candidate name (natural order of String)
        TreeMap<String, Integer> sortedResultsByName = new TreeMap<>(votes);
        System.out.println("--- Voting Results (Sorted by Candidate Name) ---");
        sortedResultsByName.forEach((candidate, count) -> System.out.println(candidate + ": " + count + " votes"));

        // Use TreeMap with a custom comparator to sort results by vote count (descending)
        TreeMap<String, Integer> sortedResultsByVotes = new TreeMap<>(Comparator.comparing(votes::get).reversed());
        sortedResultsByVotes.putAll(votes); // Add all entries from the votes map
        System.out.println("\n--- Voting Results (Sorted by Vote Count - Descending) ---");
        sortedResultsByVotes.forEach((candidate, count) -> System.out.println(candidate + ": " + count + " votes"));
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");

        System.out.println("--- Vote Counts (HashMap - Unordered) ---");
        system.getVoteCounts().forEach((candidate, count) -> System.out.println(candidate + ": " + count));

        System.out.println("\n--- Vote Order (LinkedHashMap - Order of Votes) ---");
        system.getVoteOrder().forEach((candidate, order) -> System.out.println(candidate + " (Vote #" + order + ")"));

        system.displayResultsSorted();
    }
}