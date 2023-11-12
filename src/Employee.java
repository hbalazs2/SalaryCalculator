abstract class Employee {
    private int employeeId;
    private String name;
    private String position;
    private int workingHoursPerDay;
    private int workedHours;
    private int remainingHours;
    private int overtimeHours;
    private double salary; // New field for hourly rate
    private double baseSalary; // New field for base salary
    private double overtimeRate; // New field for overtime rate

    public Employee(int employeeId, String name, String position, int workingHoursPerDay, double salary, double overtimeRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.workingHoursPerDay = workingHoursPerDay;
        this.workedHours = 0;
        this.remainingHours = 0;
        this.overtimeHours = 0;
        this.salary = salary;
        this.baseSalary = baseSalary;
        this.overtimeRate = overtimeRate;
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

    public double getSalary() {
        return salary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }
}