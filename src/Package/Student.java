package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private static int sequence = 2024000;
    private final String registrationPerson;
    private final List<Classroom> classrooms = new ArrayList<>();
    private final List<Test> tests = new ArrayList<>();

    public Student(String name, String cpf, String email) {
        super(name, cpf, email);
        this.registrationPerson = "MAT-" + (++sequence);
    }

    public Student(String name, String cpf, String email, String registrationPerson) {
        super(name, cpf, email);
        this.registrationPerson = registrationPerson;
    }

    public String getRegistration() {
        return registrationPerson;
    }

    public void addClassroom(Classroom classroom) {
        if (classroom != null && !classrooms.contains(classroom)) {
            classrooms.add(classroom);
        }
    }

    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    public List<Classroom> getClassrooms() {
        return Collections.unmodifiableList(classrooms);
    }

    public void addTest(Test test) {
        if (test != null && !tests.contains(test)) {
            tests.add(test);
        }
    }

    public List<Test> getTests() {
        return Collections.unmodifiableList(tests);
    }

    public void getTest() {
        System.out.println("=== Consulta de Notas do Aluno: " + getName() + " (Matrícula: " + registrationPerson + ") ===");
        if (tests.isEmpty()) {
            System.out.println("  Nenhuma avaliação registrada para este aluno.");
        } else {
            for (Test test : tests) {
                System.out.print("  - ");
                test.showTest();
            }
        }
    }

    public void getClassroom() {
        System.out.println("=== Consulta de Turmas do Aluno: " + getName() + " (Matrícula: " + registrationPerson + ") ===");
        if (classrooms.isEmpty()) {
            System.out.println("  O aluno não está matriculado em nenhuma turma.");
        } else {
            for (Classroom classroom : classrooms) {
                System.out.println("  - Turma: " + classroom.getCode() +
                        " | Disciplina: " + classroom.getDiscipline().getName() +
                        " | Professor: " + classroom.getTeacher().getName());
            }
        }
    }

    @Override
    public void getData() {
        System.out.println("Aluno: " + getName() + " | Matrícula: " + registrationPerson + " | CPF: " + getCpf() + " | E-mail: " + getEmail());
    }

    @Override
    public String toString() {
        return "Aluno: " + getName() + " (Matrícula: " + registrationPerson + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(registrationPerson, student.registrationPerson) ||
                (cpf != null && Objects.equals(cpf, student.cpf));
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationPerson, cpf);
    }
}
