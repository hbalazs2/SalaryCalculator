class Manager extends Employee {
    public Manager(int employeeId, String name, int workingHoursPerDay, double baseSalary, double overtimeRate) {
        super(employeeId, name, "Manager", workingHoursPerDay,  baseSalary, overtimeRate);
    }

    @Override
    public int calculateSalary() {
        return (int) ((getSalary() / 160) * getWorkedHours() + getOvertimeHours() * ((getSalary() / 160) * (1 + getOvertimeRate())));
    }
}