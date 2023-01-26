package org.gb.homework.schooldata.view;

import org.gb.homework.schooldata.view.tools.ConsoleHelper;

//Меню
public class SchoolDataView {

    public int showMenu() {
        System.out.println("\nУчебное заведение");
        System.out.println("1. Учителя");
        System.out.println("2. Студенты");

        System.out.println("0. Выход");

        return ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x -> x >= 0 && x <= 2);
    }

    public void showWorkComplete() {
        System.out.println("Работа завершена...");
    }


    public void showTaskError() {
        System.out.println("Задача не выбрана");
    }
}
