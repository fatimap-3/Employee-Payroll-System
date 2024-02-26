package PayrollSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME TO THE EMPLOYYE PAYROLL SYSTEM\n");
    	System.out.println("Please choose what you want to do today from the options below.");

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Calculate and Display Salaries");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    addFullTimeEmployee(payrollSystem, scanner);
                    break;
                case 2:
                    addPartTimeEmployee(payrollSystem, scanner);
                    break;
                case 3:
                    removeEmployee(payrollSystem, scanner);
                    break;
                case 4:
                    displayEmployees(payrollSystem);
                    break;
                case 5:
                    calculateAndDisplaySalaries(payrollSystem);
                    break;
                case 6:
                    System.out.println("Changes have been saved.\nExiting the Payroll System.\nHave a nice day.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addFullTimeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Full-Time Employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Full-Time Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Full-Time Employee monthly salary: ");
        double monthlySalary = scanner.nextDouble();
        scanner.nextLine();  // consume the newline character

        FullTimeEmployee emp = new FullTimeEmployee(name, id, monthlySalary);
        payrollSystem.addEmployee(emp);
        System.out.println("Full-Time Employee added successfully.");
    }

    private static void addPartTimeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Part-Time Employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Part-Time Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Part-Time Employee hours worked: ");
        int hoursWorked = scanner.nextInt();
        System.out.print("Enter Part-Time Employee hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        scanner.nextLine();  // consume the newline character

        PartTimeEmployee emp = new PartTimeEmployee(name, id, hoursWorked, hourlyRate);
        payrollSystem.addEmployee(emp);
        System.out.println("Part-Time Employee added successfully.");
    }

    private static void removeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        payrollSystem.removeEmployee(id);
        System.out.println("Employee removed successfully.");
    }

    private static void displayEmployees(PayrollSystem payrollSystem) {
        System.out.println("\nEmployee Details:");
        payrollSystem.displayEmployees();
    }

    private static void calculateAndDisplaySalaries(PayrollSystem payrollSystem) {
        payrollSystem.calculateAndDisplaySalaries();
    }
}