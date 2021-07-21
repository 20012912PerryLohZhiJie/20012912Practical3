package sg.edu.rp.c346.id20012912.practical3;

import java.io.Serializable;

public class Client implements Serializable
{
    private int id;
    private String name;
    private int salespotential;

    public Client(String name, int id, int salespotential)
    {
        this.name = name;
        this.id = id;
        this.salespotential = salespotential;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalespotential() {
        return salespotential;
    }

    public void setSalespotential(int salespotential) {
        this.salespotential = salespotential;
    }
}
