package org.gb.homework.mvccalculator.model;

public interface Calculator {

    public boolean isOperation(String s);

    double pushAction(String op);

//    double pushActionHistory(String op, boolean isHistory);
//
//    void operation(String op);
//
//    void calcStackInit();
}
