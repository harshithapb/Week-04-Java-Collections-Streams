package org.test.example;
import org.example.TemperatureConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0));
        assertEquals(212.0, converter.celsiusToFahrenheit(100));
    }
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32));
        assertEquals(100.0, converter.fahrenheitToCelsius(212));
    }
    @Test
    void testNegativeCelsiusToFahrenheit() {
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40));
    }
    @Test
    void testNegativeFahrenheitToCelsius() {
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40));
    }
}

