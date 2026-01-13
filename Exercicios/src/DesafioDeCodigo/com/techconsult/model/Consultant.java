package DesafioDeCodigo.com.techconsult.model;

public abstract class Consultant {
    protected String name;
    protected String role;

    public Consultant(String name, String role) {
        this.name = name;
        this.role = role;
    }
    public String present() {
        return role + ": " + name;
    }
}
