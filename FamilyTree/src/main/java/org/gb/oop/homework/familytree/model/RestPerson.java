package org.gb.oop.homework.familytree.model;

import org.gb.oop.homework.familytree.model.ambience.BoxFurniture;
import org.gb.oop.homework.familytree.model.ambience.HomeAnimal;

/**
 * Класс, который демонстрирует взаимодействие человека с окружением
 * в "домашней" обстановке
 */
public class RestPerson {

    private final Person person;

    public RestPerson(Person person) {
        this.person = person;
    }

    /**
     * Открыть шкаф
     */
    public void OpenTheBoxFurniture(BoxFurniture boxFurniture) {
        thinking("Надо открыть шкаф");
        boxFurniture.openTheDoor();
    }


    /**
     * Закрыть шкаф
     */
    public void CloseTheBoxFurniture(BoxFurniture boxFurniture) {
        thinking("Надо закрыть шкаф");
        boxFurniture.closeTheDoor();
    }


    /**
     * Позвать питомца
     */
    public void CallPet(HomeAnimal pet, String sound) {
        thinking("Надо позвать питомца " + sound);
        pet.hears(sound);
    }

    private void thinking(String s) {
        System.out.println(person.getName() + ": \"" + s + "\"");
    }
}
