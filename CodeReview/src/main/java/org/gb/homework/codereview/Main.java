package org.gb.homework.codereview;

import org.gb.homework.codereview.controllers.Process;
import org.gb.homework.codereview.controllers.Processable;
import org.gb.homework.codereview.model.Picture;
import org.gb.homework.codereview.model.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Code Review задачи, рашаемой на семинаре.
 * <p>
 * Выполнен рефакторинг задачи:
 * <p>
 * 1. Можно создавать экземпляры обработчиков
 * 2. Можно добавлять типы файлов, без изменения класса обработчика
 * 3. Передача параметров в контроллер происходит по типу интерфейса (не по слишком общему типу Object)
 * 4. Классы распределены по package
 * <p>
 * ИТОГ:
 * Структура проекта стала более поддерживаемой, менее хрупкой
 */
public class Main {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        List<Processable> processableList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во элементов: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println("txt or picture");

        for (int i = 0; i < index; i++) {
            String choice = scanner.nextLine();
            if ("txt".equals(choice)) {
                Text myText = new Text("Testing the text format");
                processableList.add(myText);
            } else if ("picture".equals(choice)) {
                Picture picture = new Picture(22);
                processableList.add(picture);
            } else System.out.println("Что-то Вы не то ввели");
        }

        System.out.println("\nРезультат:");

        var p = new Process();

        for (var plItem : processableList) {
            p.processing(plItem);
        }
    }
}
