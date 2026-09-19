package Package;

public class Test {
    private final Student student;
    private double value;
    private final String description;

    public Test(Student student, double value, String description) {
        this.student = student;
        this.value = value;
        this.description = description;
    }

    public Student getStudent(){
        return student;
    }

    public double getValue(){
        return value;
    }
    public String getDescription(){
        return description;
    }

    public void setValue(double value){
        this.value = value;
    }

    public void showTest(){

    }
}
