package Policy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Define a custom DateTimeFormatter for consistency
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               ", Policyholder: " + policyholderName +
               ", Expiry Date: " + expiryDate.format(DATE_FORMATTER) +
               ", Coverage: " + coverageType +
               ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagementSystem2{
    private Map<String, InsurancePolicy> policiesByNumber = new HashMap<>();
    private Map<String, InsurancePolicy> policiesByInsertionOrder = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<InsurancePolicy>> policiesByExpiryDate = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        policiesByNumber.put(policy.getPolicyNumber(), policy);
        policiesByInsertionOrder.put(policy.getPolicyNumber(), policy);

        // Store in TreeMap by expiry date
        policiesByExpiryDate.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policiesByNumber.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(days);
        List<InsurancePolicy> expiringSoon = new ArrayList<>();

        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry : policiesByExpiryDate.entrySet()) {
            LocalDate expiry = entry.getKey();
            if (!expiry.isBefore(today) && !expiry.isAfter(futureDate)) {
                expiringSoon.addAll(entry.getValue());
            } else if (expiry.isAfter(futureDate)) {
                // Since TreeMap is sorted by expiry date, we can break early
                break;
            }
        }
        return expiringSoon;
    }

    public List<InsurancePolicy> getPoliciesByPolicyholder(String policyholderName) {
        List<InsurancePolicy> holderPolicies = new ArrayList<>();
        for (InsurancePolicy policy : policiesByNumber.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        List<String> expiredPolicyNumbers = new ArrayList<>();
        List<LocalDate> expiredExpiryDates = new ArrayList<>();

        // Identify expired policies in policiesByNumber and policiesByInsertionOrder
        for (InsurancePolicy policy : policiesByNumber.values()) {
            if (policy.getExpiryDate().isBefore(today)) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }

        // Remove from policiesByNumber and policiesByInsertionOrder
        for (String policyNumber : expiredPolicyNumbers) {
            policiesByNumber.remove(policyNumber);
            policiesByInsertionOrder.remove(policyNumber);
        }

        // Identify and remove from policiesByExpiryDate
        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry : policiesByExpiryDate.entrySet()) {
            LocalDate expiryDate = entry.getKey();
            List<InsurancePolicy> policiesToRemove = new ArrayList<>();
            for (InsurancePolicy policy : entry.getValue()) {
                if (policy.getExpiryDate().isBefore(today)) {
                    policiesToRemove.add(policy);
                }
            }
            entry.getValue().removeAll(policiesToRemove);
            if (entry.getValue().isEmpty()) {
                expiredExpiryDates.add(expiryDate);
            }
        }
        for (LocalDate expiredDate : expiredExpiryDates) {
            policiesByExpiryDate.remove(expiredDate);
        }
    }

    public void displayAllPolicies() {
        System.out.println("All Policies (by insertion order):");
        for (InsurancePolicy policy : policiesByInsertionOrder.values()) {
            System.out.println(policy);
        }
        System.out.println("\nAll Policies (sorted by expiry date):");
        policiesByExpiryDate.forEach((date, policyList) -> {
            policyList.forEach(policy -> System.out.println(policy));
        });
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem2 system = new InsurancePolicyManagementSystem2();

        // Add some policies
        system.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.of(2025, 6, 15), "Health", 500.00));
        system.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.of(2025, 5, 20), "Auto", 300.00));
        system.addPolicy(new InsurancePolicy("P103", "Alice", LocalDate.of(2025, 7, 10), "Home", 400.00));
        system.addPolicy(new InsurancePolicy("P104", "Charlie", LocalDate.of(2025, 5, 10), "Health", 550.00));
        system.addPolicy(new InsurancePolicy("P105", "Bob", LocalDate.of(2025, 8, 1), "Auto", 320.00));
        system.addPolicy(new InsurancePolicy("P106", "Alice", LocalDate.of(2025, 5, 1), "Life", 200.00)); // Expired

        system.displayAllPolicies();

        System.out.println("\nPolicy with number P103: " + system.getPolicyByNumber("P103"));

        System.out.println("\nPolicies expiring within the next 30 days:");
        system.getPoliciesExpiringSoon(30).forEach(System.out::println);

        System.out.println("\nPolicies for policyholder Alice:");
        system.getPoliciesByPolicyholder("Alice").forEach(System.out::println);

        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();

        System.out.println("\nPolicies after removing expired ones:");
        system.displayAllPolicies();
    }
}

