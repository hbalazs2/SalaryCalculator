abstract class Employee {
    private int employeeId;
    private String name;
    private String position;
    private int workingHoursPerDay;
    private int workedHours;
    private int remainingHours;
    private int overtimeHours;

    public Employee(int employeeId, String name, String position, int workingHoursPerDay) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.workingHoursPerDay = workingHoursPerDay;
        this.workedHours = 0;
        this.remainingHours = 0;
        this.overtimeHours = 0;
    }

    public void addWorkHours(int hours) {
        if (hours > workingHoursPerDay) {
            overtimeHours += hours - workingHoursPerDay;
            workedHours += workingHoursPerDay;
        } else {
            workedHours += hours;
        }
    }

    public void addOvertimeHours(int hours) {
        overtimeHours += hours;
    }

    public int getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public abstract int calculateSalary();

    public int getRemainingHours() {
        remainingHours = workingHoursPerDay - workedHours;
        return remainingHours;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }
}