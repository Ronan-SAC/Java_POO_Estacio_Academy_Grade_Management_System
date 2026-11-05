package Package;

public class Test {
    public static final double MIN_VALUE = 0.0;
    public static final double MAX_VALUE = 10.0;

    private final Student student;
    private double value;
    private final String description;

    public Test(Student student, double value, String description) {
        if (student == null) {
            throw new IllegalArgumentException("A nota deve estar associada a um aluno existente.");
        }
        validateValue(value);
        this.student = student;
        this.value = value;
        this.description = description;
    }

    private static void validateValue(double value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Nota inválida: %.2f. O valor deve estar entre %.1f e %.1f.", value, MIN_VALUE, MAX_VALUE));
        }
    }

    public Student getStudent() {
        return student;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public void setValue(double value) {
        validateValue(value);
        this.value = value;
    }

    public void showTest() {
        System.out.printf("Atividade: %-25s | Aluno: %-20s (Mat: %s) | Nota: %.2f%n",
                description, student.getName(), student.getRegistration(), value);
    }

    @Override
    public String toString() {
        return String.format("Atividade: %s | Aluno: %s | Nota: %.2f", description, student.getName(), value);
    }
}
