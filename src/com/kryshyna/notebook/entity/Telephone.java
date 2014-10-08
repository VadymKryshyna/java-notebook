package com.kryshyna.notebook.entity;

/**
 * @author Vadym Kryshyna
 */
public class Telephone {
    private int id;
    private String number;
    private int fkid;

    public int getFkid() {
        return fkid;
    }

    public void setFkid(int fkid) {
        this.fkid = fkid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {

        return id;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", fkid=" + fkid +
                '}';
    }
}
