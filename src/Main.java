import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = CatalogHandler.readEmployeesFromCatalog("../data/catalogs/catalog");
        String directoryPath = "../data/registers/";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        boolean cont = true;
        while (cont) {
            int choice = 0;
            if (files != null) {
                choice = attendanceChooser(files);
            }
            assert files != null;
            WorkHourHandler.readWorkHours(employees, files[choice].getAbsolutePath());
            printSalaries(employees);
            printEmployeesByRemainingHours(employees);
            printMonthlyExpensesAndLosses(employees);
            cont = isContinued();
        }
    }

    public static void printSalaries(List<Employee> employees) {
        System.out.println("Salaries:");
        for (Employee employee : employees) {
            int salary = employee.calculateSalary();
            System.out.println(employee.getName() + " - Salary: " + salary);
        }
    }

    public static void printEmployeesByRemainingHours(List<Employee> employees) {
        Collections.sort(employees, (e1, e2) -> e2.getRemainingHours() - e1.getRemainingHours());
        System.out.println("\nEmployees sorted by remaining hours:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " - Remaining Hours: " + employee.getRemainingHours());
        }
    }

    public static void printMonthlyExpensesAndLosses(List<Employee> employees) {
        int totalMonthlyExpenses = 0;
        int totalLosses = 0;
        for (Employee employee : employees) {
            totalMonthlyExpenses += employee.calculateSalary();
            int remainingHours = employee.getRemainingHours();
            if (remainingHours > 0) {
                if (employee instanceof Manager) {
                    totalLosses += (int) (remainingHours * (employee.getSalary() / 160));
                } else if (employee instanceof  Worker) {
                    totalLosses += (int) (remainingHours * employee.getSalary());
                }
            }
        }

        System.out.println("\nTotal Monthly Expenses: " + totalMonthlyExpenses);
        System.out.println("Total Losses Due to Unworked Hours: " + totalLosses);
    }

    public static int attendanceChooser(File[] files) {
        int choice = -1;
        do {
            System.out.println("Choose which attendance register do you want to read? ");
            for (int i = 0; i < files.length; i++) {
                System.out.printf("%d. " + files[i].getName() + "\n", i + 1);
            }
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt() - 1;
            System.out.println();
        } while (choice == -1);
        return choice;
    }

    public static boolean isContinued() {
        boolean isContinued;
        System.out.println("Do you wish to read another attendance? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "Y":
                isContinued = true;
                break;
            case "N":
                isContinued = false;
                break;
            default:
                isContinued = false;
                System.out.println("Invalid answer, the system quits");
                break;
        }
        return isContinued;
    }
}
