import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    // Employee class to store employee details
    static class Employee {
        private int employeeID;
        private String name;
        private double salary;
        private String department;

        // Constructor to initialize employee details
        public Employee(int employeeID, String name, double salary, String department) {
            this.employeeID = employeeID;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        // Getter and Setter methods
        public int getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        // Method to calculate net salary after 10% tax deduction
        public double calculateNetSalary() {
            return salary - (salary * 0.10);
        }

        // Method to display employee details
        public String toString() {
            return "ID: " + employeeID + ", Name: " + name + ", Salary: " + salary +
                   ", Department: " + department + ", Net Salary: " + calculateNetSalary();
        }
    }

    // EmployeeManager class to manage all operations
    static class EmployeeManager {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Method to add a new employee
        void addEmployee() {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            Employee emp = new Employee(id, name, salary, dept);
            employees.add(emp);
            System.out.println("Employee added successfully!");
        }

        // Method to view all employee details
        void viewEmployees() {
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }

        // Method to update employee's salary or department
        void updateEmployee() {
            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();
            Employee emp = findEmployeeById(id);
            if (emp == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.println("1. Update Salary");
            System.out.println("2. Update Department");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter new Salary: ");
                double newSalary = sc.nextDouble();
                emp.setSalary(newSalary);
                System.out.println("Salary updated.");
            } else if (choice == 2) {
                System.out.print("Enter new Department: ");
                String newDept = sc.nextLine();
                emp.setDepartment(newDept);
                System.out.println("Department updated.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        // Method to delete an employee by ID
        void deleteEmployee() {
            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();
            Employee emp = findEmployeeById(id);
            if (emp == null) {
                System.out.println("Employee not found!");
                return;
            }
            employees.remove(emp);
            System.out.println("Employee deleted successfully.");
        }

        // Helper method to find employee by ID
        Employee findEmployeeById(int id) {
            for (Employee emp : employees) {
                if (emp.getEmployeeID() == id) {
                    return emp;
                }
            }
            return null;
        }
    }

    // Main method with console menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        int choice;

        do {
            // Displaying menu
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Menu functionality
            switch (choice) {
                case 1:
                    manager.addEmployee();
                    break;
                case 2:
                    manager.viewEmployees();
                    break;
                case 3:
                    manager.updateEmployee();
                    break;
                case 4:
                    manager.deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
}