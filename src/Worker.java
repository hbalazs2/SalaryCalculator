class Worker extends Employee {
    public Worker(int employeeId, String name, int workingHoursPerDay, double hourlyRate, double overtimeRate) {
        super(employeeId, name, "Worker", workingHoursPerDay, hourlyRate,  overtimeRate);
    }

    @Override
    public int calculateSalary() {
        return (int) (getWorkedHours() * getSalary() + getOvertimeHours() * getSalary() * (1 + getOvertimeRate()));
    }
}