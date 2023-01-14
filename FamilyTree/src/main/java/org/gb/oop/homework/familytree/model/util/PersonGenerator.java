package org.gb.oop.homework.familytree.model.util;

import org.gb.oop.homework.familytree.model.Person;

import java.util.Random;

/***
 *
 */
public class PersonGenerator {

    public static final int MaxDepth = 7;
    public static Random rnd = new Random();

    public static Person createPerson() {

        var sb = new StringBuilder();

        sb.append(Character.toUpperCase((char) rnd.nextInt('a', 'z')));
        for (int i = 0; i < rnd.nextInt(2, 6); i++) {
            sb.append((char) rnd.nextInt('a', 'z'));
        }
        sb.append(rnd.nextInt(1000));

        return new Person(sb.toString());
    }

    public static void AddParents(Person p1) {
        AddParents(p1, 0);
    }

    public static void AddParents(Person p1, int depth) {
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
}
