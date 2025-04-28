package org.example;
import java.util.Scanner;
public class Performance {
    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            return "Interrupted";
        }
        return "Task Completed";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Performance p = new Performance();
        System.out.println("Result: " + p.longRunningTask());
    }
}

