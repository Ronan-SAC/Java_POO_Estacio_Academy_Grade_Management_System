package Package;

public class Teacher extends Person {
    private static int sequence = 1000;
    private final String registrationTeacher;

    public Teacher(String name, String cpf, String email) {
        super(name, cpf, email);
        this.registrationTeacher = "PRF-" + (++sequence);
    }

    public Teacher(String name, String cpf, String email, String registrationTeacher) {
        super(name, cpf, email);
        this.registrationTeacher = registrationTeacher;
    }

    public String getRegistrationTeacher() {
        return registrationTeacher;
    }

    public Student registerStudent(String name, String cpf, String email) {
        return new Student(name, cpf, email);
    }

    public Discipline registerDiscipline(String name, int workload) {
        return new Discipline(name, workload);
    }

    public Classroom registerCourse(Discipline discipline) {
        return new Classroom(discipline, this);
    }

    public Test registerTest(Student student, double value, String description) {
        return new Test(student, value, description);
    }

    @Override
    public void getData() {
        System.out.println("Professor: " + getName() + " | Registro: " + registrationTeacher + " | CPF: " + getCpf() + " | E-mail: " + getEmail());
    }

    @Override
    public String toString() {
        return "Professor: " + getName() + " (Registro: " + registrationTeacher + ")";
    }
}
