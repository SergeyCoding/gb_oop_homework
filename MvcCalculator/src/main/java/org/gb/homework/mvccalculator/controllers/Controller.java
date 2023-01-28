package org.gb.homework.mvccalculator.controllers;


import org.gb.homework.mvccalculator.model.Calculator;
import org.gb.homework.mvccalculator.view.View;

import java.util.function.Predicate;

public class Controller {
    private final Calculator calc;
    private final View view;

    public Controller(Calculator calc, View view) {
        this.calc = calc;
        this.view = view;
    }

    public void run() {
        view.showTitle();

        while (true) {
            String s = view.getOperation(new Controller.CalcOperationPredicate());


            if (s.equals("exit"))
                break;

            view.showResult(calc.pushAction(s));
        }

    }


    private class CalcOperationPredicate implements Predicate<String> {
        @Override
        public boolean test(String s) {
            if (calc.isOperation(s) || s.equalsIgnoreCase("exit")) {
                return true;
            }

            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
}
