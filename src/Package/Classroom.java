package Package;

import java.util.ArrayList;

public class Classroom {
    private String code;
    private final Discipline discipline;
    private final Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList<Test> tests;

    public Classroom(Discipline discipline, Teacher teacher){
        this.discipline = discipline;
        this.teacher = teacher;
        this.code = String.valueOf(Math.random());
    }

    public void registerStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void listStudents(){
        for(Student student : students){
            System.out.println(student);
        }
    }

    public void listTests(){
        for(Test test : tests) {
            System.out.println(test);
        }
    }

    public void registerTest(Test test){
        this.tests.add(test);
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
