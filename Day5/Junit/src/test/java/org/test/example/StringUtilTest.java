package org.test.example;
import org.example.StringUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringUtilTest {
    private StringUtil su;
    @BeforeEach
    void setup(){
        su = new StringUtil();
    }
    @Test
    @DisplayName("Reverse the String")
    void rev(){
        assertEquals("cba",su.reverse("abc"));
    }
    @Test
    @DisplayName("Palindrome True")
    void PalinTrue(){
        assertTrue(su.isPalindrome("mam"));
    }
    @Test
    @DisplayName("Palindrome False")
    void PalinFalse(){
        assertFalse(su.isPalindrome("hello"));
    }
    @Test
    @DisplayName("Upper Case")
    void Upper(){
        assertEquals("HELLO",su.toUpper("hello"));
    }
}

