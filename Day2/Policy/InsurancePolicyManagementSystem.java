package Policy;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InsurancePolicyManagementSystem implements Comparable<InsurancePolicyManagementSystem> {
    int id;
    String name;
    ExpiryDate expiryDate;
    String coverage;
    float premiumAmount;

    private HashSet<InsurancePolicyManagementSystem> hashSetPolicies = new HashSet<>();
    private LinkedHashSet<InsurancePolicyManagementSystem> linkedHashSetPolicies = new LinkedHashSet<>();
    private TreeSet<InsurancePolicyManagementSystem> treeSetPolicies = new TreeSet<>();

    public static class ExpiryDate {
        int date;
        int month;
        int year;

        public ExpiryDate(int date, int month, int year) {
            this.date = date;
            this.month = month;
            this.year = year;
        }

        @Override
        public String toString() {
            return date + "/" + month + "/" + year;
        }
    }

    public InsurancePolicyManagementSystem(int id, String name, ExpiryDate expiryDate, String coverage, float premiumAmount) {
        this.id = id;
        this.name = name;
        this.expiryDate = expiryDate;
        this.coverage = coverage;
        this.premiumAmount = premiumAmount;
    }

    public int getId() {
        return id;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverage() {
        return coverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicyManagementSystem policy = (InsurancePolicyManagementSystem) o;
        return id == policy.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(InsurancePolicyManagementSystem other) {
        if (this.expiryDate.year != other.expiryDate.year) {
            return Integer.compare(this.expiryDate.year, other.expiryDate.year);
        }
        if (this.expiryDate.month != other.expiryDate.month) {
            return Integer.compare(this.expiryDate.month, other.expiryDate.month);
        }
        return Integer.compare(this.expiryDate.date, other.expiryDate.date);
    }

    @Override
    public String toString() {
        return "Policy Number: " + id +
               ", Policyholder Name: " + name +
               ", Expiry Date: " + expiryDate +
               ", Coverage Type: " + coverage +
               ", Premium Amount: " + premiumAmount;
    }

    public void addPolicy(InsurancePolicyManagementSystem policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public Set<InsurancePolicyManagementSystem> getAllUniquePolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    public Set<InsurancePolicyManagementSystem> getPoliciesExpiringSoon(int days) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        Date futureDate = calendar.getTime();

        return treeSetPolicies.stream()
                .filter(policy -> {
                    Calendar expiryCal = Calendar.getInstance();
                    expiryCal.set(policy.expiryDate.year, policy.expiryDate.month - 1, policy.expiryDate.date);
                    Date expiry = expiryCal.getTime();
                    return expiry.after(today) && expiry.before(futureDate);
                })
                .collect(Collectors.toSet());
    }

    public Set<InsurancePolicyManagementSystem> getPoliciesByCoverageType(String coverageType) {
        return hashSetPolicies.stream()
                .filter(policy -> policy.getCoverage().equalsIgnoreCase(coverageType))
                .collect(Collectors.toSet());
    }

    public Set<InsurancePolicyManagementSystem> findDuplicatePolicies(List<InsurancePolicyManagementSystem> allPolicies) {
        Set<Integer> policyNumbers = new HashSet<>();
        Set<InsurancePolicyManagementSystem> duplicates = new HashSet<>();

        for (InsurancePolicyManagementSystem policy : allPolicies) {
            if (!policyNumbers.add(policy.getId())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public long measureAddTime(Set<InsurancePolicyManagementSystem> set, InsurancePolicyManagementSystem policy) {
        long startTime = System.nanoTime();
        set.add(policy);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long measureRemoveTime(Set<InsurancePolicyManagementSystem> set, InsurancePolicyManagementSystem policy) {
        long startTime = System.nanoTime();
        set.remove(policy);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long measureSearchTime(Set<InsurancePolicyManagementSystem> set, int policyNumber) {
        long startTime = System.nanoTime();
        boolean found = set.stream().anyMatch(policy -> policy.getId() == policyNumber);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem manager = new InsurancePolicyManagementSystem(0, null, null, null, 0); // Dummy instance to call methods

        // Create some policies
        ExpiryDate date1 = new ExpiryDate(10, 5, 2026);
        ExpiryDate date2 = new ExpiryDate(15, 6, 2026);
        ExpiryDate date3 = new ExpiryDate(20, 5, 2026);
        ExpiryDate date4 = new ExpiryDate(10, 5, 2026);
        ExpiryDate date5 = new ExpiryDate(1, 6, 2025);

        InsurancePolicyManagementSystem policy1 = new InsurancePolicyManagementSystem(101, "Alice", date1, "Health", 500.0f);
        InsurancePolicyManagementSystem policy2 = new InsurancePolicyManagementSystem(102, "Bob", date2, "Auto", 300.0f);
        InsurancePolicyManagementSystem policy3 = new InsurancePolicyManagementSystem(101, "Charlie", date3, "Home", 400.0f);
        InsurancePolicyManagementSystem policy4 = new InsurancePolicyManagementSystem(103, "David", date4, "Health", 550.0f);
        InsurancePolicyManagementSystem policy5 = new InsurancePolicyManagementSystem(104, "Eve", date5, "Auto", 320.0f);

        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);
        manager.addPolicy(policy4);
        manager.addPolicy(policy5);

        System.out.println("All Unique Policies (HashSet):");
        manager.getAllUniquePolicies().forEach(System.out::println);

        System.out.println("\nAll Unique Policies (LinkedHashSet - Insertion Order):");
        manager.linkedHashSetPolicies.forEach(System.out::println);

        System.out.println("\nAll Unique Policies (TreeSet - Sorted by Expiry Date):");
        manager.treeSetPolicies.forEach(System.out::println);

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        manager.getPoliciesExpiringSoon(30).forEach(System.out::println);

        System.out.println("\nPolicies with Coverage Type 'Health':");
        manager.getPoliciesByCoverageType("Health").forEach(System.out::println);

        List<InsurancePolicyManagementSystem> allPoliciesList = List.of(policy1, policy2, policy3, policy4, policy5);
        System.out.println("\nDuplicate Policies based on Policy Number:");
        manager.findDuplicatePolicies(allPoliciesList).forEach(System.out::println);

        // Performance Comparison
        int numPolicies = 1000;
        List<InsurancePolicyManagementSystem> manyPolicies = new java.util.ArrayList<>();
        for (int i = 0; i < numPolicies; i++) {
            ExpiryDate d = new ExpiryDate(i % 30 + 1, (i % 12) + 1, 2026 + (i % 5));
            manyPolicies.add(new InsurancePolicyManagementSystem(200 + i, "Person " + i, d, "Type " + (i % 3), 100.0f + i));
        }
        InsurancePolicyManagementSystem searchPolicy = manyPolicies.get(numPolicies / 2);

        HashSet<InsurancePolicyManagementSystem> testHashSet = new HashSet<>(manyPolicies);
        LinkedHashSet<InsurancePolicyManagementSystem> testLinkedHashSet = new LinkedHashSet<>(manyPolicies);
        TreeSet<InsurancePolicyManagementSystem> testTreeSet = new TreeSet<>(manyPolicies);

        long hashSetAddTime = 0;
        long linkedHashSetAddTime = 0;
        long treeSetAddTime = 0;
        for (InsurancePolicyManagementSystem p : manyPolicies) {
            hashSetAddTime += manager.measureAddTime(testHashSet, p);
            linkedHashSetAddTime += manager.measureAddTime(testLinkedHashSet, p);
            treeSetAddTime += manager.measureAddTime(testTreeSet, p);
        }

        long hashSetSearchTime = manager.measureSearchTime(testHashSet, searchPolicy.getId());
        long linkedHashSetSearchTime = manager.measureSearchTime(testLinkedHashSet, searchPolicy.getId());
        long treeSetSearchTime = manager.measureSearchTime(testTreeSet, searchPolicy.getId());

        InsurancePolicyManagementSystem removePolicy = manyPolicies.get(0);
        long hashSetRemoveTime = manager.measureRemoveTime(testHashSet, removePolicy);
        long linkedHashSetRemoveTime = manager.measureRemoveTime(testLinkedHashSet, removePolicy);
        long treeSetRemoveTime = manager.measureRemoveTime(testTreeSet, removePolicy);

        System.out.println("\n--- Performance Comparison (for " + numPolicies + " policies) ---");
        System.out.println("Adding:");
        System.out.println("  HashSet: " + hashSetAddTime + " ns");
        System.out.println("  LinkedHashSet: " + linkedHashSetAddTime + " ns");
        System.out.println("  TreeSet: " + treeSetAddTime + " ns");

        System.out.println("\nSearching for Policy Number " + searchPolicy.getId() + ":");
        System.out.println("  HashSet: " + hashSetSearchTime + " ns");
        System.out.println("  LinkedHashSet: " + linkedHashSetSearchTime + " ns");
        System.out.println("  TreeSet: " + treeSetSearchTime + " ns");

        System.out.println("\nRemoving Policy Number " + removePolicy.getId() + ":");
        System.out.println("  HashSet: " + hashSetRemoveTime + " ns");
        System.out.println("  LinkedHashSet: " + linkedHashSetRemoveTime + " ns");
        System.out.println("  TreeSet: " + treeSetRemoveTime + " ns");
    }
}