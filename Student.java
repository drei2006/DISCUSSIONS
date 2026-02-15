public class Student extends Person {

    private String idNo;
    private String course;

    public Student(String idNo, String firstName, String lastName, String course) {
        super(firstName, lastName);
        this.idNo = idNo;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
