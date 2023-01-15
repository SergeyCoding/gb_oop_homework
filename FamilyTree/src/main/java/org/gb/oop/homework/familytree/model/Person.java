package org.gb.oop.homework.familytree.model;

/**
 * Член семьи
 */
public class Person {
    private final String name;
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

    public boolean isParentOf(Person p) {
        return p.getFather() == this || p.getMother() == this;
    }

    public boolean isChildOf(Person p) {
        return p.isParentOf(this);
    }

    public boolean isBrother(Person p) {
        var m = mother != null && mother.isParentOf(p);
        var f = father != null && father.isParentOf(p);
        return this != p && (m || f);
    }

    public boolean isAncestorOf(Person p) {
        if (isParentOf(p))
            return true;

        var f = (father != null) && father.isAncestorOf(p);
        var m = (mother != null) && mother.isAncestorOf(p);

        return f || m;
    }

    @Override
    public String toString() {
        return name + "(Mother: " + (mother == null ? "-" : mother.name) + "; Father: " + (father == null ? "-" : father.name) + ")";
    }

    public boolean hasParent() {
        return father != null || mother != null;
    }
}

