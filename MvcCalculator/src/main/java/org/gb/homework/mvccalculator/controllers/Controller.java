package org.gb.homework.mvccalculator.controllers;


import org.gb.homework.mvccalculator.model.SimpleCalculator;
import org.gb.homework.mvccalculator.view.CalcView;
import org.gb.homework.mvccalculator.view.tools.ConsoleHelper;

import java.util.function.Predicate;

public class Controller {
    public Controller(SimpleCalculator model, CalcView view) {
    }

    public static void run() {
        CalcView.show();

        var calc = new SimpleCalculator();

        while (true) {
            var s = ConsoleHelper.getString("> ", new CalcOperationPredicate());

            if (s.equals("exit"))
                break;

            System.out.println(calc.pushAction(s));
        }

    }


    private static class CalcOperationPredicate implements Predicate<String> {
        @Override
        public boolean test(String s) {
            if (SimpleCalculator.isOperation(s) || s.equalsIgnoreCase("exit")) {
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
