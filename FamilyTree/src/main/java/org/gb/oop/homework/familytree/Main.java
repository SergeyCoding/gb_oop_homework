package org.gb.oop.homework.familytree;

import org.gb.tools.ConsoleHelper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Seminar04");
        System.out.println("1. Телефонная книга");
        System.out.println("2. Сотрудники");
        System.out.println("3. Пирамидальная сортировка");
        System.out.println("4. 8 ферзей");
        System.out.println("0. Выход");

        var numberTask = ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x -> x >= 0 && x <= 4);

        switch (numberTask) {
//            case 1 -> PhonebookManager.run();
            default -> System.out.println("Задача не выбрана");
        }
    }
}