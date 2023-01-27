package org.gb.homework.mvccalculator;

import org.gb.homework.mvccalculator.controllers.Controller;
import org.gb.homework.mvccalculator.model.impl.CalculatorImpl;
import org.gb.homework.mvccalculator.view.CalcView;

/**
 * Написать калькулятор, соблюдая MVC паттерн( сложение, вычитание, умножение и деление)
 */
public class Main {

    public static void main(String[] args) {
        var controller = new Controller(new CalculatorImpl(), new CalcView());
        controller.run();
    }
}