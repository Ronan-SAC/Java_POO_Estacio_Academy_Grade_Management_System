package Package;

public abstract class Person {
    protected String name;
    protected String cpf;
    protected String email;

    public Person() {
    }

    public Person(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public void getData() {
        System.out.println("Nome: " + name + " | CPF: " + cpf + " | E-mail: " + email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + name + " | CPF: " + cpf + " | E-mail: " + email;
    }
}
