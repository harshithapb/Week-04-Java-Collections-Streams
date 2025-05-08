package interface_pgms;

import java.util.*;
class Person {
    String name;
    int age;
    double salary;
    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
public class SortPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            people.add(new Person(name, age, salary));
        }
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));
        System.out.println("\nSorted List by Age:");
        for (Person p : people) {
            System.out.println("Name: " + p.name + ", Age: " + p.age + ", Salary: " + p.salary);
        }
    }
}
