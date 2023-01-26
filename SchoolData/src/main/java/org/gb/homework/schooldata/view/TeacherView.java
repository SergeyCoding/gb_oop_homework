package org.gb.homework.schooldata.view;

import org.gb.homework.schooldata.model.Teacher;
import org.gb.homework.schooldata.view.tools.ConsoleHelper;

import java.util.List;

public class TeacherView {

    public int showMenu(Teacher currentTeacher) {
        System.out.println("\nУчителя");

        if (currentTeacher != null) {
            System.out.printf("Текущий учитель: %s\n", currentTeacher.getName());
        }

        System.out.println("1. Показать всех учителей");
        System.out.println("2. Выбрать");
        System.out.println("3. Добавить");
        System.out.println("4. Изменить");
        System.out.println("5. Удалить");

        System.out.println("0. Вернуться в главное меню");

        return ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x -> x >= 0 && x <= 5);
    }

    public void showAll(List<Teacher> users) {
        if (users.size() == 0) {
            System.out.println("\nНет ни одного учителя");
            return;
        }

        System.out.println("Список учителей:");

        for (var u : users) {
            System.out.println(u);
        }
    }

    public void showTaskError() {
        System.out.println("Задача не выбрана");
    }

    public int getTeacherId(int maxId) {
        if (maxId < 1) {
            System.out.println("\nНет ни одного учителя");
            return -1;
        }

        return ConsoleHelper.getNaturalInteger("Выберите учителя: ", x -> x >= 0 && x <= maxId - 1);
    }

    public String inputName() {
        return ConsoleHelper.getString("Добавление учителя. Введите имя: ");
    }
}
