package org.gb.oop.homework.familytree.model;

import org.gb.tools.ConsoleHelper;

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
        for (int i = 0; i < personList.size(); i++) {
            System.out.printf("%d - %s\n", i, personList.get(i));
        }
    }

    public int getCount() {
        return personList.size();
    }

    public void choosePerson() {
        printAll();
        activePerson = ConsoleHelper.getNaturalInteger("Номер члена сообщества: ", x -> x >= 0 && x < personList.size());
    }

    public void printChildren() {
        var ap = personList.get(activePerson);
        System.out.print("\nСписок детей: \n");
        for (var p : personList) {
            if (ap.isParentOf(p))
                System.out.println(p);
        }
    }

    public void printParents() {
        var ap = personList.get(activePerson);
        System.out.println("Родители:");
        System.out.printf("Мать: %s\n", ap.getMother() == null ? "-" : ap.getMother().getName());
        System.out.printf("Отец: %s\n", ap.getFather() == null ? "-" : ap.getFather().getName());
    }

    public void printBrothers() {
        var ap = personList.get(activePerson);
        System.out.print("\nСписок братьев и сестер: \n");
        for (var p : personList) {
            if (ap.isParentOf(p))
                System.out.println(p);
        }
    }

    public void printIsSameFamily() {
        Person ap = getActivePerson();

        printAll();
        var p2 = ConsoleHelper.getNaturalInteger("Номер члена сообщества: ", x -> x >= 0 && x < personList.size());

        ap.isAncestorOf(personList.get(p2));
    }

//    private void isAncestorOf(Person ap) {
//        List<Person> pl = new ArrayList<>();
//        getAncestors(pl, ap);
//
//        for (var p : pl) {
//            System.out.println(p);
//        }
//    }
//
//    public void getAncestors(List<Person> pl, Person p) {
//        Person ap = getActivePerson();
//
//        printAll();
//        var p2 = ConsoleHelper.getNaturalInteger("Номер члена сообщества: ", x -> x >= 0 && x < personList.size());
//
//        if ()
//    }
}
