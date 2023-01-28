package org.gb.homework.mvccalculator.model.impl;


import org.gb.homework.mvccalculator.model.Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class CalculatorImpl implements Calculator {

    private static final List<String> op = Arrays.asList("+", "-", "*", "/", "c", "cc");

    private final Stack<Double> calcStack = new Stack<>();
    private final Stack<String> calcStackHistory = new Stack<>();

    public CalculatorImpl() {
        calcStackInit();
    }


    public boolean isOperation(String s) {
        return op.contains(s);
    }

    @Override
    public double pushAction(String op) {
        return pushActionHistory(op, false);
    }

    @Override
    public double pushActionHistory(String op, boolean isHistory) {
        if (!isHistory) {
            calcStackHistory.push(op);
        }

        if (isOperation(op)) {
            operation(op);
        } else {
            calcStack.push(Double.parseDouble(op));
        }

        return calcStack.peek();
    }

    @Override
    public void operation(String op) {
        if (calcStack.size() == 0) {
            calcStack.push(0d);
        }
        if (calcStack.size() == 1) {
            var tmp = calcStack.pop();
            calcStack.push(0d);
            calcStack.push(tmp);
        }

        switch (op) {
            case "+" -> calcStack.push(calcStack.pop() + calcStack.pop());
            case "-" -> {
                var tmp = calcStack.pop();
                calcStack.push(calcStack.pop() - tmp);
            }
            case "*" -> calcStack.push(calcStack.pop() * calcStack.pop());
            case "/" -> {
                var tmp = calcStack.pop();
                calcStack.push(calcStack.pop() / tmp);
            }
            case "c" -> {
                calcStackInit();

                calcStackHistory.pop();

                if (calcStackHistory.size() > 0) {
                    calcStackHistory.pop();
                }

                for (var item : calcStackHistory) {
                    pushActionHistory(item, true);
                }
            }
            case "cc" -> {
                calcStackInit();
                calcStackHistory.clear();
            }
        }
    }

    @Override
    public void calcStackInit() {
        calcStack.clear();
        calcStack.push(0d);
    }
}
