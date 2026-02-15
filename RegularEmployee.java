// RegularEmployee class
public class RegularEmployee extends Employee implements ICompute {

    private int hoursWorked;
    private int hourlyRate;

    public RegularEmployee(String idNo, String firstName, String lastName,
                           String position, String department,
                           int hoursWorked, int hourlyRate) {

        super(idNo, firstName, lastName, position, department, "Regular");
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Salary
    public String computeSalary() {
        int salary = hoursWorked * hourlyRate;
        return "Salary: " + salary;
    }
}
