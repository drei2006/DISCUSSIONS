public class ContractualEmployee extends Employee implements ICompute {

    private int overtime;

    public ContractualEmployee(String idNo, String firstName, String lastName,
                               String position, String department,
                               int overtime) {

        super(idNo, firstName, lastName, position, department, "Contractual");
        this.overtime = overtime;
    }

    // Salary 
    public String computeSalary() {
        int salary = overtime * 150;
        return "Salary: " + salary;
    }
}
