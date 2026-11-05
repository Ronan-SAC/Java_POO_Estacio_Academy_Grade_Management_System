package Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Classroom {
    private static int sequence = 100;
    private final String code;
    private final Discipline discipline;
    private final Teacher teacher;
    private final List<Student> students;
    private final List<Test> tests;

    public Classroom(Discipline discipline, Teacher teacher) {
        this.code = "TURMA-" + (++sequence);
        this.discipline = discipline;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.tests = new ArrayList<>();
    }

    public Classroom(String code, Discipline discipline, Teacher teacher) {
        this.code = code;
        this.discipline = discipline;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.tests = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<Test> getTests() {
        return Collections.unmodifiableList(tests);
    }

    public boolean registerStudent(Student student) {
        if (student == null) {
            System.out.println("[Aviso] Não é possível matricular aluno nulo.");
            return false;
        }
        if (this.students.contains(student)) {
            System.out.println("[Regra Mínima] Aluno já matriculado nesta turma: " + student.getName() + " (Matrícula: " + student.getRegistration() + "). Não permitido duplicar.");
            return false;
        }
        this.students.add(student);
        student.addClassroom(this);
        return true;
    }

    public boolean removeStudent(Student student) {
        if (student != null && this.students.remove(student)) {
            student.removeClassroom(this);
            return true;
        }
        return false;
    }

    public boolean registerTest(Test test) {
        if (test == null) {
            System.out.println("[Aviso] Não é possível registrar avaliação nula.");
            return false;
        }
        if (!this.students.contains(test.getStudent())) {
            System.out.println("[Regra Mínima] O aluno " + test.getStudent().getName() + " não pertence à turma " + code + ". Nota não vinculada.");
            return false;
        }
        this.tests.add(test);
        test.getStudent().addTest(test);
        return true;
    }

    public void listStudents() {
        System.out.println("=== Relação de Alunos da Turma " + code + " (" + discipline.getName() + ") ===");
        if (students.isEmpty()) {
            System.out.println("  Nenhum aluno matriculado nesta turma.");
        } else {
            int i = 1;
            for (Student student : students) {
                System.out.printf("  %d. %s | Matrícula: %s | CPF: %s | E-mail: %s%n",
                        i++, student.getName(), student.getRegistration(), student.getCpf(), student.getEmail());
            }
        }
    }

    public void listTests() {
        System.out.println("=== Relação de Notas da Turma " + code + " (" + discipline.getName() + ") ===");
        if (tests.isEmpty()) {
            System.out.println("  Nenhuma avaliação registrada nesta turma.");
        } else {
            for (Test test : tests) {
                System.out.print("  - ");
                test.showTest();
            }
        }
    }

    public void getData() {
        System.out.println("Turma: " + code + " | Disciplina: " + discipline.getName() +
                " | Professor: " + teacher.getName() + " | Qtd Alunos: " + students.size() +
                " | Qtd Avaliações: " + tests.size());
    }

    @Override
    public String toString() {
        return "Turma: " + code + " (" + discipline.getName() + ") - Prof. " + teacher.getName();
    }
}
