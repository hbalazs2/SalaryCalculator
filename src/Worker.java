class Worker extends Employee {
    private double hourlyRate;
    private double overtimeRate;

    public Worker(int employeeId, String name, int workingHoursPerDay, double hourlyRate, double overtimeRate) {
        super(employeeId, name, "Worker", workingHoursPerDay);
        this.hourlyRate = hourlyRate;
        this.overtimeRate = overtimeRate;
    }

    @Override
    public int calculateSalary() {
        return (int) ((getWorkedHours() * hourlyRate) + getOvertimeHours() * hourlyRate * (1 + overtimeRate));
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}