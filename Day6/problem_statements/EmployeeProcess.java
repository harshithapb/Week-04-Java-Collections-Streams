package problem_statements;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import java.util.stream.Collectors;
class Employee {
    int id;
    String name;
    String department;
    double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public String toString() {
        return id + " - " + name + " (" + department + ") : $" + salary;
    }
}
public class EmployeeProcess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter number of employees: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            employees.add(new Employee(id, name, department, salary));
        }
        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("\nFiltered & Sorted Engineering Employees:");
        filteredSorted.forEach(System.out::println);
        Map<String, List<Employee>> groupedByDept = filteredSorted.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nGrouped by Department:");
        groupedByDept.forEach((dept, empList) -> {
            System.out.println(dept + ":");
            empList.forEach(System.out::println);
        });
        System.out.println("\nAverage Salary per Department:");
        groupedByDept.forEach((dept, empList) -> {
            double avgSalary = empList.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
            System.out.printf("%s -> $%.2f\n", dept, avgSalary);
        });
    }
}

