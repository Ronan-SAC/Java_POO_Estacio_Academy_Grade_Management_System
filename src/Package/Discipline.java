package Package;

public class Discipline {
    private String code;
    private String name;
    private int workload;

    public Discipline(String name, int workload) {
        this.code = String.valueOf(Math.random());
        this.name = name;
        this.workload = workload;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getWorkload() {
        return workload;
    }

    public void getData(){
        code = getCode();
        name = getName();
        workload = getWorkload();
    }
}
