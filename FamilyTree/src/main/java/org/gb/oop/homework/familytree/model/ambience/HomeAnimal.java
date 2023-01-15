package org.gb.oop.homework.familytree.model.ambience;

/**
 * Базовый класс для домашнего питомца
 */
public class HomeAnimal {

    protected String name;
    protected boolean sleeping;

    public HomeAnimal(String name) {
        this.name = name;
    }

    public void hears(String sound) {
        printState("");
    }

    protected void say(String s) {
        printState(s);
    }

    public void say() {
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sleep(boolean isSleep) {
        sleeping = isSleep;

        if (sleeping) {
            printState("спит");
        } else {
            printState("не спит");
        }
    }

    protected void printState(String s) {
        System.out.println(name + ": " + s);
    }
}
