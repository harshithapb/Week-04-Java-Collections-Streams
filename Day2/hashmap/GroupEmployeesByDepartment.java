package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class GroupEmployeesByDepartment {

    public static Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            String department = employee.getDepartment();
            // If the department is already a key in the map, add the employee to the list
            if (departmentMap.containsKey(department)) {
                departmentMap.get(department).add(employee);
            } else {
                // If the department is not yet a key, create a new list and add the employee
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(employee);
                departmentMap.put(department, employeeList);
            }
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        employees.add(new Employee("David", "Finance"));
        employees.add(new Employee("Eve", "IT"));
        employees.add(new Employee("Frank", "HR"));

        Map<String, List<Employee>> employeesByDepartment = groupEmployeesByDepartment(employees);

        System.out.println("Employees: " + employees);
        System.out.println("Employees grouped by department:");

        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}