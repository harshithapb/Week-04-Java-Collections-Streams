package org.example;
public class StringUtil {
    public String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public boolean isPalindrome(String str){
        String r = reverse(str);
        return str.equalsIgnoreCase(r);
    }
    public String toUpper(String str){
        return str.toUpperCase();
    }
}
