package org.gb.homework.mvccalculator.view;

import org.gb.homework.mvccalculator.controllers.Controller;

import java.util.logging.Logger;

/**
 *
 */
public class CalcView implements View {
    public void show() {
        System.out.println("Калькулятор (обратная польская нотация)");

        System.out.println("\nВводите либо число, либо операцию (+, -, *, /)");
        System.out.println("c - для отмены операции");
        System.out.println("cc - сброс (после него отмена невозможна)");
        System.out.println("exit - выход\n");    }

}
