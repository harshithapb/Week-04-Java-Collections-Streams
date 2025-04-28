package org.test.example;
import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Test addition")
    void testAdd() {
        assertEquals(7, calculator.add(3, 4));
    }
    @Test
    @DisplayName("Test subtraction")
    void testSubtract() {
        assertEquals(1, calculator.subtract(5, 4));
    }
    @Test
    @DisplayName("Test multiplication")
    void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
    }
    @Test
    @DisplayName("Test division")
    void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
    }
    @Test
    @DisplayName("Test division by zero")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}

