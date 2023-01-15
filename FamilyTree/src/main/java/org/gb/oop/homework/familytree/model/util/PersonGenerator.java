package org.gb.oop.homework.familytree.model.util;

import org.gb.oop.homework.familytree.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 *Генератор дерева семей
 */
public class PersonGenerator {

    public static final int MaxDepth = 7;
    public static Random rnd = new Random();
    private final int countFamily;
    private final List<Person> people = new ArrayList<>();

    public PersonGenerator(int countFamily) {
        this.countFamily = countFamily;
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person createPerson() {

        var sb = new StringBuilder();

        sb.append(Character.toUpperCase((char) rnd.nextInt('a', 'z')));
        for (int i = 0; i < rnd.nextInt(2, 6); i++) {
            sb.append((char) rnd.nextInt('a', 'z'));
        }
        sb.append(rnd.nextInt(1000));

        return new Person(sb.toString());
    }

    public void AddParents(Person p1) {
        AddParents(p1, 0);
    }

    public Person AddBrother(Person p1) {
        var p2 = createPerson();
        p2.setMother(p1.getMother());
        p2.setFather(p1.getFather());
        return p2;
    }

    public void AddParents(Person p1, int depth) {
        if (depth > MaxDepth)
            return;

        if (rnd.nextInt(10) > 3) {
            p1.setFather(createPerson());
            AddParents(p1.getFather(), depth + 1);
        }

        if (rnd.nextInt(10) > 3) {
            p1.setMother(createPerson());
            AddParents(p1.getMother(), depth + 1);
        }
    }

    public void generatePeople() {
        for (int i = 0; i < countFamily; i++) {
            var p1 = createPerson();
            AddParents(p1);
            fillArray(p1);
        }

        for (Person person : people.stream().toList()) {
            if (person.hasParent()) {
                for (int i = 1; i < rnd.nextInt(4); i++) {
                    people.add(AddBrother(person));
                }
            }
        }
    }

    private void fillArray(Person person) {
        if (person == null) {
            return;
        }

        if (!people.contains(person)) {
            people.add(person);
            fillArray(person.getMother());
            fillArray(person.getFather());
        }
    }
}
