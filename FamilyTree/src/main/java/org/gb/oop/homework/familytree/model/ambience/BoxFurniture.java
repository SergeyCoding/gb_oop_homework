package org.gb.oop.homework.familytree.model.ambience;

import java.util.Stack;

/**
 * Шкаф
 */
public class BoxFurniture {

    private final int maxCountThings;
    private boolean isTheDoorOpen;
    private Stack<String> things = new Stack<>();

    public BoxFurniture(int maxCountThings) {
        this.maxCountThings = maxCountThings;
        this.isTheDoorOpen = false;
    }

    public void openTheDoor() {
        if (isTheDoorOpen) {
            System.out.println("Попытка открыть открытый шкаф");
            return;
        }

        isTheDoorOpen = true;
        System.out.println("Шкаф открыли");
    }

    public void closeTheDoor() {
        if (!isTheDoorOpen) {
            System.out.println("Попытка закрыть закрытый шкаф");
            return;
        }

        isTheDoorOpen = false;
        System.out.println("Шкаф закрыли");
    }

    public void Put(String s) {
        if (things.size() >= maxCountThings) {
            System.out.println("Попытка положить вещь в заполненный шкаф");
            return;
        }

        things.push(s);
        System.out.printf("В шкаф положили %s", s);
    }

    public void Get() {
        if (things.size() == 0) {
            System.out.println("Попытка взять вещи из пустого шкафа");
            return;
        }

        var s = things.pop();
        System.out.printf("Из шкафа взяли %s", s);
    }
}
