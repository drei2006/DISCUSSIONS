public class TestPerson {

    public static void main(String[] args) {

        RegularEmployee re = new RegularEmployee(
                "101", "Juan", "Dela Cruz",
                "Programmer", "IT",
                50, 700
        );

        ContractualEmployee ce = new ContractualEmployee(
                "102", "Maria", "Santos",
                "Designer", "Creative",
                50
        );

        Student s = new Student(
                "201", "Ana", "Reyes",
                "BSIT"
        );

        System.out.println(re.displayInfo());
        System.out.println(re.computeSalary());

        System.out.println(ce.displayInfo());
        System.out.println(ce.computeSalary());

        System.out.println(s.displayInfo());
        System.out.println("Course: " + s.getCourse());
    }
}
