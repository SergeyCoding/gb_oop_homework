package org.gb.oop.homework.familytree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Сообщество людей, включенных в дерево (может быть несколько семей)
 */
public class Society {

    private int activePerson;

    private final List<Person> personList = new ArrayList<>();

    public Society(List<Person> rootPersonList) {
        for (var p : rootPersonList) {
            fillArray(p);
        }

        activePerson = 0;
    }

    public List<Person> getPersonList() {
        return new ArrayList<>(personList);
    }

    public Person getActivePerson() {
        return personList.get(activePerson);
    }

    public void setActivePerson(int activePerson) {
        this.activePerson = activePerson;
    }


    private void fillArray(Person person) {
        if (person == null) {
            return;
        }
        personList.add(person);
        fillArray(person.getMother());
        fillArray(person.getFather());
    }

    public void printAll() {
        for (var p : personList) {
            System.out.println(p);
        }
    }

    public int getCount() {
        return personList.size();
    }

    public void choosePerson() {
    }
}
