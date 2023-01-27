package org.gb.homework.mvccalculator.view;

import org.gb.homework.mvccalculator.controllers.Controller;

import java.util.logging.Logger;

public class CalcView {
    public static void show() {
        System.out.println("\nСеминар 4.");
        System.out.println("Задача 3.");

        var logFilename = "calc_log.txt";

        System.out.println("Вводите либо число, либо операцию (+, -, *, /)");
        System.out.println("c - для отмены операции");
        System.out.println("cc - сброс (после него отмена невозможна)");
        System.out.println("exit - выход\n");
    }
}
