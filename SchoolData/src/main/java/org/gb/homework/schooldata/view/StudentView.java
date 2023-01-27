package org.gb.homework.schooldata.view;

import org.gb.homework.schooldata.model.Student;
import org.gb.homework.schooldata.view.tools.ConsoleHelper;

import java.time.LocalDate;
import java.util.List;

public class StudentView {

    public int showMenu(Student currentStudent) {
        System.out.println("\nСтуденты:");

        if (currentStudent != null) {
            System.out.printf("Текущий студент: %s\n", currentStudent.getName());
        }

        System.out.println("1. Показать всех студентов");
        System.out.println("2. Выбрать");
        System.out.println("3. Добавить");
        System.out.println("4. Изменить");
        System.out.println("5. Удалить");

        System.out.println("0. Вернуться в главное меню");

        return ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x -> x >= 0 && x <= 5);
    }

    public void showAll(List<Student> users) {
        if (users.size() == 0) {
            System.out.println("\nНет ни одного студента");
            return;
        }

        System.out.println("Список студентов:");

        for (var u : users) {
            System.out.println(u);
        }
    }

    public void showTaskError() {
        System.out.println("Задача не выбрана");
    }

    public int getStudentId(int nextId) {
        if (nextId == 0) {
            System.out.println("\nНет ни одного студента");
            return -1;
        }

        return ConsoleHelper.getNaturalInteger("Выберите id студента: ", x -> x >= 0 && x < nextId);
    }

    public String inputName() {
        System.out.println("Добавление студента.");
        return ConsoleHelper.getString("Введите имя: ", x -> !x.isBlank());
    }

    public void showCurrentStudentError() {
        System.out.println("Не выбран студент");
    }

    public int inputGrade() {
        return ConsoleHelper.getNaturalInteger("Оценка: ", x -> x >= 1 && x <= 5);
    }

    public int inputYear() {
        return ConsoleHelper.getNaturalInteger("Год: ", x -> x >= 1900 && x <= LocalDate.now().getYear() + 1);
    }
}
