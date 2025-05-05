package banking;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Customer {
    String accountNumber;
    String name;
    double balance;

    public Customer(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful from account " + accountNumber);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount for account " + accountNumber);
        } else {
            System.out.println("Insufficient balance in account " + accountNumber + " for withdrawal of $" + amount);
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Name: " + name + ", Balance: $" + String.format("%.2f", balance);
    }
}

public class BankingSystem {

    private Map<String, Customer> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalRequests = new LinkedList<>();

    public void createAccount(String accountNumber, String name, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new Customer(accountNumber, name, initialBalance));
            System.out.println("Account " + accountNumber + " created for " + name + " with initial balance $" + initialBalance);
        } else {
            System.out.println("Account number " + accountNumber + " already exists.");
        }
    }

    public Customer getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void submitWithdrawalRequest(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalRequests.offer(new WithdrawalRequest(accountNumber, amount));
            System.out.println("Withdrawal request submitted for account " + accountNumber + ", amount: $" + amount);
        } else {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    public void processWithdrawalRequests() {
        System.out.println("\n--- Processing Withdrawal Requests ---");
        while (!withdrawalRequests.isEmpty()) {
            WithdrawalRequest request = withdrawalRequests.poll();
            Customer customer = accounts.get(request.getAccountNumber());
            if (customer != null) {
                customer.withdraw(request.getAmount());
            } else {
                System.out.println("Account " + request.getAccountNumber() + " not found for withdrawal request.");
            }
        }
        System.out.println("--- All withdrawal requests processed ---");
    }

    public void displayCustomersSortedByBalance() {
        // Use TreeMap with a custom comparator to sort customers by balance
        TreeMap<String, Customer> sortedCustomersByBalance = new TreeMap<>(Comparator.comparing(customer -> accounts.get(customer).getBalance()));
        sortedCustomersByBalance.putAll(accounts);

        System.out.println("\n--- Customers Sorted by Balance ---");
        sortedCustomersByBalance.forEach((accountNumber, customer) -> System.out.println(customer));
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount("1001", "Alice", 1000.00);
        bank.createAccount("1002", "Bob", 500.00);
        bank.createAccount("1003", "Charlie", 1500.00);
        bank.createAccount("1001", "Another Alice", 200.00); // Attempt to create duplicate account

        bank.submitWithdrawalRequest("1001", 200.00);
        bank.submitWithdrawalRequest("1002", 600.00); // Insufficient funds
        bank.submitWithdrawalRequest("1003", 1000.00);
        bank.submitWithdrawalRequest("1004", 100.00); // Non-existent account

        bank.processWithdrawalRequests();

        System.out.println("\n--- Account Balances ---");
        System.out.println(bank.getAccount("1001"));
        System.out.println(bank.getAccount("1002"));
        System.out.println(bank.getAccount("1003"));

        bank.displayCustomersSortedByBalance();
    }
}

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
