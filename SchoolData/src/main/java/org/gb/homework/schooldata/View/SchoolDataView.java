package org.gb.homework.schooldata.View;

//Меню
public class SchoolDataView {

    public void update() {

    }

    public void showMenu() {
        var isWorking = true;

        while (isWorking) {
            System.out.println("\nУчебное заведение");
            System.out.println("1. Вывести всех учителей");
            System.out.println("2. Выбрать всех учеников");
            System.out.println("3. Выбрать учителя");
            System.out.println("4. Выбрать ученика");
            System.out.println("5. Добавить учителя");
            System.out.println("6. Добавить ученика");
            System.out.println("7. Демонстрация взаимодействия с окружением");

            System.out.println("0. Выход");

            var numberTask = ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x -> x >= 0 && x <= 7);

            switch (numberTask) {
                case 0 -> isWorking = false;
//                case 1 -> society.printAll();
//                case 2 -> society.choosePerson();
//                case 3 -> society.printParents();
//                case 4 -> society.printChildren();
//                case 5 -> society.printBrothers();
//                case 6 -> society.printIsSameFamily();
//                case 7 -> RestAmbienceManager.run(society.getActivePerson());
                default -> System.out.println("Задача не выбрана");
            }
        }

        System.out.println("Работа завершена...");
    }
}
