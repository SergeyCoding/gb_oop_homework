package org.gb.homework.mvccalculator.view;

import java.util.function.Predicate;

public interface View {
    void showTitle();

    String getOperation(Predicate<String> predicate);

    void showResult(double result);
}
