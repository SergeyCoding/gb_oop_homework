package org.gb.oop.homework.familytree.model.ambience;

public class Dog extends HomeAnimal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void hears(String sound) {
        if (sleeping) {
            printState("спит и не слышит");
            return;
        }
        if (sound.equals(name))
            say();
        else
            say("???");
    }

    @Override
    public void say() {
        super.say("гав");
    }

}
