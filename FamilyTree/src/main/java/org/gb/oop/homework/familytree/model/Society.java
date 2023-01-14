package org.gb.oop.homework.familytree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Сообщество людей, включенных в дерево (может быть несколько семей)
 */
public class Society {

    public List<Person> getPersonList() {
        return new ArrayList<>(personList);
    }

    private final List<Person> personList = new ArrayList<>();

    public Society(List<Person> rootPersonList) {
        for (var p : rootPersonList) {
            fillArray(p);
        }
    }

    private void fillArray(Person person) {
        if (person == null) {
            return;
        }
        personList.add(person);
        fillArray(person.Mother);
        fillArray(person.Father);
    }

    public void printAll() {
        for (var p : personList) {
            System.out.println(p);
        }
    }

    public int getCount() {
        return personList.size();
    }
}
