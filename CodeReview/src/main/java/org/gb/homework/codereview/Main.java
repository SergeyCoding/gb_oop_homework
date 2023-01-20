package org.gb.homework.codereview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Code Review задачи, рашаемой на семинаре.
 * <p>
 * Обратим внимание на класс Process.
 * <p>
 * Во-первых, класс содержит только один, причем статический метод,
 * поэтому экземпляры данного класса создавать бессысленно.
 * Но создание нескольких классов может быть необходимо, например,
 * класс Process может использоваться кнопками, а кнопок может быть несколько
 * Нарушение принципа одной ответственности.
 * <p>
 * Как следствие, нельзя использовать, например несколько "кнопок",
 * основанных на данном классе.
 * <p>
 * Во-вторых, внутри метода происходит проверка на передаваемый аргумент.
 * Не используются возможности ООП. Стиль напоминает процедурную парадигму.
 * Антипаттерн божественный метод. Нарушение принципа Лисков (предположение о типе)
 * <p>
 * В-третьих, при добавлении нового обработчка, придется добавлять условия в
 * метод processing. Нарушение принципа закрытости для модификации-открытости для добавления
 * <p>
 * Рассмотрим классы Text, Picture:
 * <p>
 * Во-первых, классы должны обрабатываться сходным образом. А это значит,
 * что для них можно создать общий класс-предок, или интерфейс (лучше)
 * <p>
 * Во-вторых, внешний обработчик для классов Text, Picture должен знать о внутренней структуре
 * этих классов. Лучше, если обработчик будет внутри этих классов - будет соблюден принцип
 * инкапсуляции.
 * <p>
 * ИТОГ:
 * Если классы реализивать в соответствви с выше указанным пунктами, будет легко добавить класс
 * для еще какого-либо типа. При этом не будет необходимости изменять класс Process.
 */
public class Main {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        List<Object> objects = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во элементов: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("txt or picture");

        for (int i = 0; i <= index; i++) {
            String choice = scanner.nextLine();
            if ("txt".equals(choice)) {
                Text myText = new Text("Testing the text format");
                objects.add(myText);
            } else if ("picture".equals(choice)) {
                Picture picture = new Picture(22);
                objects.add(picture);
            } else System.out.println("Что-то Вы не то ввели");
        }

        objects.forEach(Process::processing);
    }
}
