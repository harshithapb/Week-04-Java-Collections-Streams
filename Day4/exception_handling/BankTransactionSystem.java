package exception_handling;


//Custom checked exception
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

class BankAccount {
 private double balance;
 private String accountNumber;

 public BankAccount(String accountNumber, double initialBalance) {
     this.accountNumber = accountNumber;
     this.balance = initialBalance;
 }

 public String getAccountNumber() {
     return accountNumber;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
     } else {
         System.err.println("Invalid deposit amount: Amount must be positive.");
     }
 }

 public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {
     if (amount <= 0) {
         throw new IllegalArgumentException("Invalid amount: Amount must be positive.");
     }
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance!");
     }
     balance -= amount;
     System.out.println("Withdrawal of $" + amount + " successful, new balance: $" + balance);
 }
}

public class BankTransactionSystem {
 public static void main(String[] args) {
     BankAccount account1 = new BankAccount("123456", 1000);

     System.out.println("Account: " + account1.getAccountNumber() + ", Initial Balance: $" + account1.getBalance());

     // Valid withdrawal
     try {
         account1.withdraw(500);
     } catch (InsufficientBalanceException e) {
         System.err.println("Error: " + e.getMessage());
     } catch (IllegalArgumentException e) {
         System.err.println("Error: " + e.getMessage());
     }

     // Withdrawal with insufficient balance
     try {
         account1.withdraw(700);
     } catch (InsufficientBalanceException e) {
         System.err.println("Error: " + e.getMessage());
     } catch (IllegalArgumentException e) {
         System.err.println("Error: " + e.getMessage());
     }

     // Invalid withdrawal amount (negative)
     try {
         account1.withdraw(-100);
     } catch (InsufficientBalanceException e) {
         System.err.println("Error: " + e.getMessage());
     } catch (IllegalArgumentException e) {
         System.err.println("Error: " + e.getMessage());
     }

     // Deposit
     account1.deposit(200);

     // Another valid withdrawal
     try {
         account1.withdraw(300);
     } catch (InsufficientBalanceException e) {
         System.err.println("Error: " + e.getMessage());
     } catch (IllegalArgumentException e) {
         System.err.println("Error: " + e.getMessage());
     }
 }
}