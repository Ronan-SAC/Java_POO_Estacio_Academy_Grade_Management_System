package Package;

public class Student extends Person{
    private final String registrationPerson;

    public Student(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.registrationPerson = String.valueOf(Math.random());
    }

    public String getRegistration() {
        return registrationPerson;
    }

    public void getTest(){

    }

    public void getClassroom(){

    }
}
