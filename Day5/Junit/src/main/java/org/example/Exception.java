package org.example;

public class Exception {
    public int div(int a, int b){
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a/b;
    }
}
