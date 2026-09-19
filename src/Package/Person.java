package Package;

abstract class Person {
    protected String name;
    protected String cpf;
    protected String email;

    protected void getData(){
        name =  getName();
        cpf = getCpf();
        email = getEmail();
    }

    protected String getName(){
        return name;
    }

    protected String getCpf(){
        return cpf;
    }

    protected String getEmail(){
        return email;
    }

    protected void setEmail(String email){
        this.email = email;
    }

}
