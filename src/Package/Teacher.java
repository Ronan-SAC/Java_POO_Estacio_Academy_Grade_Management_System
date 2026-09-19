package Package;

public class Teacher extends Person{
    private String registrationTeacher;

    public Teacher(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getRegistrationTeacher() {
        return registrationTeacher;
    }

    public void registerStudent(String name, String cpf, String email) {
        Student student = new Student(name,cpf,email);
    }

    public void registerDiscipline(){

    }

    public void registerCourse(){

    }

    public void registerTest(){

    }
}
