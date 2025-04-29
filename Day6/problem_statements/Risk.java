package problem_statements;

import java.util.*;
import java.util.stream.Collectors;
class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;
    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}
class RiskAssessment {
    String holderId;
    String name;
    double riskScore;
    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
}
public class Risk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PolicyHolder> holders = new ArrayList<>();
        System.out.print("Enter number of policy holders: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for policy holder " + i + ":");
            System.out.print("Holder ID: ");
            String holderId = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Policy Type: ");
            String policyType = scanner.nextLine();
            System.out.print("Premium Amount: ");
            double premiumAmount = Double.parseDouble(scanner.nextLine());
            holders.add(new PolicyHolder(holderId, name, age, policyType, premiumAmount));
        }
        List<PolicyHolder> filtered = holders.stream()
                .filter(h -> h.policyType.equalsIgnoreCase("Life") && h.age > 60)
                .collect(Collectors.toList());
        List<RiskAssessment> riskList = filtered.stream()
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .collect(Collectors.toList());
        List<RiskAssessment> sortedRiskList = riskList.stream()
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.toList());
        Map<String, List<RiskAssessment>> categorized = sortedRiskList.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > 500 ? "High Risk" : "Low Risk"));
        System.out.println("\nRisk Assessment by Category:");
        categorized.forEach((category, list) -> {
            System.out.println(category + ":");
            for (RiskAssessment r : list) {
                System.out.println("Holder ID: " + r.holderId + ", Name: " + r.name + ", Risk Score: " + r.riskScore);
            }
        });
    }
}
