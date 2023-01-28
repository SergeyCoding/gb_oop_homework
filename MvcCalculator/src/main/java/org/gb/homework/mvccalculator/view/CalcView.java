package org.gb.homework.mvccalculator.view;

import org.gb.homework.mvccalculator.view.tools.ConsoleHelper;

import java.util.function.Predicate;

/**
 *
 */
public class CalcView implements View {
    public void showTitle() {
        System.out.println("Калькулятор (обратная польская нотация)");

        System.out.println("\nВводите либо число, либо операцию (+, -, *, /)");
        System.out.println("c - для отмены операции");
        System.out.println("cc - сброс (после него отмена невозможна)");
        System.out.println("exit - выход\n");
    }

    @Override
    public void showResult(double result) {
        System.out.println(result);
    }

    @Override
    public String getOperation(Predicate<String> predicate) {
        return ConsoleHelper.getString("> ", predicate);
    }
}
