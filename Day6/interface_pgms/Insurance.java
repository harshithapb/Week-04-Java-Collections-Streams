package interface_pgms;

import java.util.*;
import java.util.stream.Collectors;
public class Insurance {
    static class Policy {
        String policyNumber;
        String holderName;
        double premiumAmount;
        public Policy(String policyNumber, String holderName, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.premiumAmount = premiumAmount;
        }
        public String getPolicyNumber() {
            return policyNumber;
        }
        public String getHolderName() {
            return holderName;
        }
        public double getPremiumAmount() {
            return premiumAmount;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Policy> policies = new ArrayList<>();
        System.out.print("Enter number of policies: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter policy number for policy " + (i + 1) + ":");
            String policyNumber = scanner.nextLine();
            System.out.print("Enter holder name for policy " + (i + 1) + ":");
            String holderName = scanner.nextLine();
            System.out.print("Enter premium amount for policy " + (i + 1) + ":");
            double premiumAmount = scanner.nextDouble();
            scanner.nextLine();
            policies.add(new Policy(policyNumber, holderName, premiumAmount));
        }
        System.out.println("\nPolicies with premium > 1200:");
        policies.stream().filter(p -> p.getPremiumAmount() > 1200).forEach(p -> System.out.println(p.getPolicyNumber()));
        System.out.println("\nPolicies sorted by holder name:");
        policies.stream().sorted(Comparator.comparing(Policy::getHolderName)).forEach(p -> System.out.println(p.getHolderName()));
        double totalPremium = policies.stream().mapToDouble(Policy::getPremiumAmount).sum();
        System.out.println("\nTotal premium amount: " + totalPremium);
        System.out.println("\nPolicies with premium between 1000 and 2000:");
        policies.stream().filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000).forEach(p -> System.out.println(p.getPolicyNumber()));
        Policy highestPremiumPolicy = policies.stream().max(Comparator.comparingDouble(Policy::getPremiumAmount)).orElse(null);
        System.out.println("\nPolicy with the highest premium: " + highestPremiumPolicy.getPolicyNumber());
        Map<Character, List<Policy>> groupedByInitial = policies.stream().collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
        System.out.println("\nPolicies grouped by holder name initial:");
        groupedByInitial.forEach((k, v) -> System.out.println(k + ": " + v.size()));
        double averagePremium = policies.stream().mapToDouble(Policy::getPremiumAmount).average().orElse(0);
        System.out.println("\nAverage premium: " + averagePremium);
        System.out.println("\nPolicies sorted by premium:");
        policies.stream().sorted(Comparator.comparingDouble(Policy::getPremiumAmount)).forEach(p -> System.out.println(p.getPolicyNumber()));
        boolean anyPolicyOver2000 = policies.stream().anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("\nIs there any policy with premium over 2000? " + anyPolicyOver2000);
        Map<String, Long> premiumRangeCount = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getPremiumAmount() <= 1000) return "$0-$1000";
                    else if (p.getPremiumAmount() <= 2000) return "$1001-$2000";
                    else return ">$2000";
                }, Collectors.counting()));
        System.out.println("\nCount of policies for each premium range:");
        premiumRangeCount.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("\nUnique holder names:");
        policies.stream().map(Policy::getHolderName).distinct().forEach(System.out::println);
        System.out.println("\nPolicies with 'Smith' in holder name:");
        policies.stream().filter(p -> p.getHolderName().contains("Smith")).forEach(p -> System.out.println(p.getPolicyNumber()));
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));
        System.out.println("\nMap of policy numbers to premium amounts:");
        policyMap.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("\nEnter a line of text for word frequency analysis:");
        String text = scanner.nextLine();
        List<String> words = Arrays.asList(text.split("\\W+"));
        Map<String, Long> wordCount = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("\nMost frequent words:");
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("\nSecond most frequent word:");
        String secondMostFrequent = wordCount.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst().orElse("None");
        System.out.println(secondMostFrequent);
    }
}

