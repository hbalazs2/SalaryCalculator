public class Employee {
    int id;
    String name;
    String jobTitle;
    int workHours;
    int actuallyWorkedHours;
    int nonWorkedHours;
    int workingHoursMinusOvertimeHours;

    public Employee() {
    }

    public Employee(int id, String name, String jobTitle, int workHours, int actuallyWorkedHours, int nonWorkedHours, int workingHoursMinusOvertimeHours) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.workHours = workHours;
        this.actuallyWorkedHours = actuallyWorkedHours;
        this.nonWorkedHours = nonWorkedHours;
        this.workingHoursMinusOvertimeHours = workingHoursMinusOvertimeHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getActuallyWorkedHours() {
        return actuallyWorkedHours;
    }

    public void setActuallyWorkedHours(int actuallyWorkedHours) {
        this.actuallyWorkedHours = actuallyWorkedHours;
    }

    public int getNonWorkedHours() {
        return nonWorkedHours;
    }

    public void setNonWorkedHours(int nonWorkedHours) {
        this.nonWorkedHours = nonWorkedHours;
    }

    public int getWorkingHoursMinusOvertimeHours() {
        return workingHoursMinusOvertimeHours;
    }

    public void setWorkingHoursMinusOvertimeHours(int workingHoursMinusOvertimeHours) {
        this.workingHoursMinusOvertimeHours = workingHoursMinusOvertimeHours;
    }
}
