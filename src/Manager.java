class Manager extends Employee {
    private double baseSalary;
    private double overtimeRate;
    public Manager(int employeeId, String name, int workingHoursPerDay, double baseSalary, double overtimeRate) {
        super(employeeId, name, "Manager", workingHoursPerDay);
        this.baseSalary = baseSalary;
        this.overtimeRate =overtimeRate;
    }

    @Override
    public int calculateSalary() {
        return (int) ((baseSalary / 160) * getWorkedHours() + getOvertimeHours() * (baseSalary / 160) * (1 + overtimeRate));
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}