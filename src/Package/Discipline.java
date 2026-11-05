package Package;

public class Discipline {
    private static int sequence = 100;
    private String codeDiscipline;
    private String name;
    private int workload;

    public Discipline(String name, int workload) {
        this.codeDiscipline = "DISC-" + (++sequence);
        this.name = name;
        this.workload = workload;
    }

    public Discipline(String codeDiscipline, String name, int workload) {
        this.codeDiscipline = codeDiscipline;
        this.name = name;
        this.workload = workload;
    }

    public String getCodeDiscipline() {
        return codeDiscipline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public void getData() {
        System.out.println("Disciplina: " + name + " | Código: " + codeDiscipline + " | Carga Horária: " + workload + "h");
    }

    @Override
    public String toString() {
        return "Disciplina: " + name + " (" + codeDiscipline + ") - " + workload + "h";
    }
}
