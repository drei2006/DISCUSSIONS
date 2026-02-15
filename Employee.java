public class Employee extends Person {

    protected String idNo;
    protected String position;
    protected String department;
    protected String empStatus;

    public Employee(String idNo, String firstName, String lastName,
                    String position, String department, String empStatus) {

        super(firstName, lastName);
        this.idNo = idNo;
        this.position = position;
        this.department = department;
        this.empStatus = empStatus;
    }
}
