package org.gb.oop.homework.familytree.model;

import org.gb.oop.homework.familytree.model.ambience.BoxFurniture;
import org.gb.oop.homework.familytree.model.ambience.Cat;
import org.gb.oop.homework.familytree.model.ambience.Dog;

/**
 * Демонстрация взаимодействия человека с окружением
 * <p>
 * Описать в ООП стиле, логику взаимодействия объектов реального мира между собой:
 * <p>
 * шкаф-человек.
 * <p>
 * Подумать как описать логику взаимодействия человека и домашнего питомца.
 * Сценарий: “Человек “зовёт” котика “кис-кис”, котик отзывается.
 * <p>
 * Какое ещё взаимодействие может быть?
 */
public class RestAmbienceManager {
    public static void run(Person activePerson) {
        System.out.println("\n\nДемонстрация взаимодействия человека с окружением");
        System.out.println("Создаем окружение...");
        var box = new BoxFurniture(3);
        var cat1 = new Cat("Васька");
        var cat2 = new Cat("Мурка");
        var dog = new Dog("Жучка");

        System.out.println("Создаем класс персонажа, умеющего взаимодействовать с окружением...");
        var restPerson = new RestPerson(activePerson);

        System.out.println("\nВзаимодействия:");
        cat1.sleep(true);
        cat2.sleep(false);
        dog.sleep(false);
        restPerson.CallPet(cat1, "Васька");
        restPerson.CallPet(cat2, "Мурка");
        restPerson.CallPet(dog, "Мурка");
        restPerson.CallPet(dog, "Жучка");
        restPerson.OpenTheBoxFurniture(box);
        restPerson.CloseTheBoxFurniture(box);

    }
}
