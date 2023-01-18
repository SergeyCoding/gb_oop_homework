package org.gb.oop.homework.familytree.model;

import org.gb.oop.homework.familytree.model.seminar02.ImmutablePerson;

/**
 * Член семьи
 */
public class SocietyMember {
    private final ImmutablePerson person;
    private SocietyMember mother;
    private SocietyMember father;


    public SocietyMember(ImmutablePerson person) {
        this.person = person;
    }

    public String getName() {
        return person.getName();
    }

    public SocietyMember getMother() {
        return mother;
    }

    public void setMother(SocietyMember mother) {
        this.mother = mother;
    }

    public SocietyMember getFather() {
        return father;
    }

    public void setFather(SocietyMember father) {
        this.father = father;
    }

    public boolean isParentOf(SocietyMember p) {
        return p.getFather() == this || p.getMother() == this;
    }

    public boolean isChildOf(SocietyMember p) {
        return p.isParentOf(this);
    }

    public boolean isBrother(SocietyMember p) {
        var m = mother != null && mother.isParentOf(p);
        var f = father != null && father.isParentOf(p);
        return this != p && (m || f);
    }

    public boolean isAncestorOf(SocietyMember p) {
        if (isParentOf(p))
            return true;

        var f = (father != null) && father.isAncestorOf(p);
        var m = (mother != null) && mother.isAncestorOf(p);

        return f || m;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();

        sb.append(getName());
        sb.append("(Mother: " + (mother == null ? "-" : mother.getName()) + "; Father: " + (father == null ? "-" : father.getName()) + ")");

        for (var ss : person.getSpecialSigns().entrySet()) {
            sb.append(String.format("{%s: %s}", ss.getKey(), ss.getValue()));
        }
        return sb.toString();
    }

    public boolean hasParent() {
        return father != null || mother != null;
    }
}

