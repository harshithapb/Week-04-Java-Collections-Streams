package org.test.example;
import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {
    private BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }
    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }
    @Test
    void testWithdraw() {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance());
    }
    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150.0));
    }
    @Test
    void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }
    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }
}

