import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class WorkHourHandler {
    public static void readWorkHours(List<Employee> employees, String workHourFilePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(workHourFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(";");
                int employeeId = Integer.parseInt(splitLine[0]);
                int hours = Integer.parseInt(splitLine[1]);
                for (Employee employee : employees) {
                    if (employee.getEmployeeId() == employeeId) {
                        // Calculate overtime hours and add work hours accordingly
                        int mandatoryHours = employee.getWorkingHoursPerDay();
                        int overtimeHours = Math.max(0, hours - mandatoryHours);
                        int regularHours = Math.min(hours, mandatoryHours);

                        employee.addWorkHours(regularHours);
                        employee.addOvertimeHours(overtimeHours);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

