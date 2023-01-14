package org.gb.oop.homework.familytree.model;

/**
 * Член семьи
 */
public class Person {
    private String name;
    private Person mother;
    private Person father;


    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return name + "(Mother: " + (mother == null ? "-" : mother.name) + "; Father: " + (father == null ? "-" : father.name) + ")";
    }
}

