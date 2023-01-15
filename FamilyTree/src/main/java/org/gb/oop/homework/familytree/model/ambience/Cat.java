package org.gb.oop.homework.familytree.model.ambience;

public class Cat extends HomeAnimal {


    public Cat(String name) {
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
        super.say("мяу");
    }
}
