import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CatalogHandler {

    public static List<Employee> readEmployeesFromCatalog(String catalogFilePath) {
        List<Employee> employees = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(catalogFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                int employeeId = Integer.parseInt(splitLine[0]);
                String name = splitLine[1];
                String position = splitLine[2];
                int workingHoursPerDay = Integer.parseInt(splitLine[3]);
                double salary = Double.parseDouble(splitLine[4]);
                double overtimeRate = Double.parseDouble(splitLine[5]) / 100;
                Employee employee = null;

                switch (position) {
                    case "Worker":
                        employee = new Worker(employeeId, name, workingHoursPerDay, salary, overtimeRate);
                        break;
                    case "Manager":
                        employee = new Manager(employeeId, name, workingHoursPerDay, salary, overtimeRate);
                        break;
                }
                employees.add(employee);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
