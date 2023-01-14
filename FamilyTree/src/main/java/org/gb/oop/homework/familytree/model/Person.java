package org.gb.oop.homework.familytree.model;

/**
 * Член семьи
 */
public class Person {
    public Person Mother;
    public Person Father;

    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(Mother: " + (Mother == null ? "-" : Mother.name) + "; Father: " + (Father == null ? "-" : Father.name) + ")";
    }
}

