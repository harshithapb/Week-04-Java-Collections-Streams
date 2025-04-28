package org.test.example;
import org.example.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DateFormatterTest {
    DateFormatter formatter = new DateFormatter();
    @Test
    void testValidDate() {
        assertEquals("02-05-2024", formatter.formatDate("2024-05-02"));
    }
    @Test
    void testInvalidDay() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("2024-02-30"));
    }
    @Test
    void testInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("30-04-2024"));
    }
    @Test
    void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(""));
    }
}

