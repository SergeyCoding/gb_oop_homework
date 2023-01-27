package org.gb.homework.schooldata.model;

public abstract class User {
    private final Integer id;
    protected String name;
    private boolean isActual = true;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String serialize();
}
