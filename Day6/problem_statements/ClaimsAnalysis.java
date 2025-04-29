package problem_statements;

import java.util.*;
import java.util.stream.Collectors;
class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;
    Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}
public class ClaimsAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();
        System.out.print("Enter number of claims: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for claim " + i + ":");
            System.out.print("Claim ID: ");
            String claimId = scanner.nextLine();
            System.out.print("Policy Number: ");
            String policyNumber = scanner.nextLine();
            System.out.print("Claim Amount: ");
            double claimAmount = Double.parseDouble(scanner.nextLine());
            System.out.print("Claim Date: ");
            String claimDate = scanner.nextLine();
            System.out.print("Status: ");
            String status = scanner.nextLine();
            claims.add(new Claim(claimId, policyNumber, claimAmount, claimDate, status));
        }
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
                .collect(Collectors.toList());
        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream()
                .collect(Collectors.groupingBy(c -> c.policyNumber));
        Map<String, Double> totalClaims = new HashMap<>();
        Map<String, Double> averageClaims = new HashMap<>();
        for (Map.Entry<String, List<Claim>> entry : groupedByPolicy.entrySet()) {
            String policy = entry.getKey();
            List<Claim> policyClaims = entry.getValue();
            double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
            double average = total / policyClaims.size();
            totalClaims.put(policy, total);
            averageClaims.put(policy, average);
        }
        System.out.println("\nTotal and Average Claim Amounts per Policy:");
        totalClaims.forEach((policy, total) -> {
            System.out.println("Policy: " + policy +
                    ", Total: " + total +
                    ", Average: " + averageClaims.get(policy));
        });
        System.out.println("\nTop 3 Policies by Total Claim Amount:");
        totalClaims.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    System.out.println("Policy: " + entry.getKey() +
                            ", Total Claim Amount: " + entry.getValue());
                });
    }
}
