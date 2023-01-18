package org.gb.oop.homework.familytree;

import org.gb.oop.homework.familytree.model.RestAmbienceManager;
import org.gb.oop.homework.familytree.model.Society;
import org.gb.oop.homework.familytree.model.SocietyMember;
import org.gb.oop.homework.familytree.model.util.PersonGenerator;
import org.gb.tools.ConsoleHelper;

import java.util.List;

/**
 * Реализовать, с учетом ооп подхода, приложение Для проведения исследований с генеалогическим древом.
 * <p>
 * Идея: описать некоторое количество компонент, например:
 * <p>
 * модель человека компонента хранения связей и отношений между людьми: родитель, ребёнок - классика,
 * но можно подумать и про отношение, брат, свекровь, сестра и т. д.
 * <p>
 * компонент для проведения исследований
 * <p>
 * дополнительные компоненты, например
 * <p>
 * отвечающие за вывод данных в консоль,
 * загрузку и сохранения в файл,
 * получение\построение отдельных моделей человека
 * <p>
 * <p>
 * Под “проведением исследования” можно понимать
 * <p>
 * получение всех детей выбранного человека.
 * <p>
 * Описать в ООП стиле, логику взаимодействия объектов реального мира между собой:
 * <p>
 * шкаф-человек.
 * <p>
 * Подумать как описать логику взаимодействия человека и домашнего питомца.
 * Сценарий: “Человек “зовёт” котика “кис-кис”, котик отзывается.
 * <p>
 * Какое ещё взаимодействие может быть? Продумать какие проблемы могут возникнуть в том, коде, который они написали.
 * <p>
 * Например в первой задаче (с генеалогическим древом) мы можем знать о двух людях, но не знаем в каких
 * “отношениях” они были - двоюродные или троюродные, или мы точно знаем как звали прапрабабушку,
 * но совершенно не знаем прабабушку - как хранить такие связи или что будет если в компоненту
 * обхода передать ссылку на null-дерево.
 */
public class Main {

    public static final int RootPersonCount = 2;

    public static void main(String[] args) {
        System.out.println("Генеалогическое древо");


        System.out.println("Генерация семей...");
        var pg = new PersonGenerator(RootPersonCount);
        pg.generatePeople();
        List<SocietyMember> people = pg.getPeople();

        Society society = new Society(people);
        System.out.printf("Сгенерировано %d человек\n", society.getCount());
        //society.printAll();

        var isWorking = true;

        while (isWorking) {
            System.out.println("\nГенеалогическое древо");
            System.out.printf("Текущий член сообщества: %s\n", society.getActivePerson().getName());
            System.out.println("1. Вывести всех членов сообщества");
            System.out.println("2. Выбрать члена сообщества");
            System.out.println("3. Вывести родителей");
            System.out.println("4. Вывести детей");
            System.out.println("5. Вывести братьев и сестер");
            System.out.println("6. Проверить, является ли родственником");
            System.out.println("7. Демонстрация взаимодействия с окружением");

            System.out.println("0. Выход");

            var numberTask = ConsoleHelper.getNaturalInteger("Выберите номер задачи: ", x -> x >= 0 && x <= 7);

            switch (numberTask) {
                case 0 -> isWorking = false;
                case 1 -> society.printAll();
                case 2 -> society.choosePerson();
                case 3 -> society.printParents();
                case 4 -> society.printChildren();
                case 5 -> society.printBrothers();
                case 6 -> society.printIsSameFamily();
                case 7 -> RestAmbienceManager.run(society.getActivePerson());
                default -> System.out.println("Задача не выбрана");
            }
        }

        System.out.println("Работа завершена...");
    }
}