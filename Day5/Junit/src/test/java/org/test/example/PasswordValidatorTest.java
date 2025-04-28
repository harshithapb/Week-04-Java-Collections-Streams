package org.test.example;
import org.example.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Strong1Pass"));
    }
    @Test
    void testTooShort() {
        assertFalse(validator.isValid("S1hort"));
    }
    @Test
    void testMissingUppercase() {
        assertFalse(validator.isValid("lowercase1"));
    }
    @Test
    void testMissingDigit() {
        assertFalse(validator.isValid("NoDigitPass"));
    }
}

