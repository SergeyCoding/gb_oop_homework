package org.gb.homework.schooldata.View;

import java.util.Scanner;
import java.util.function.Predicate;

public class ConsoleHelper {

    private static final Scanner scannerIn = new Scanner(System.in);

    public static int getNaturalInteger(String prompt) {
        return getFromConsole(prompt, n -> n > 0);
    }

    public static int getNaturalInteger(String prompt, Predicate<Integer> fun) {
        return getFromConsole(prompt, fun);
    }

    public static int getNaturalInteger(String prompt, Predicate<Integer> fun, int defaultValue) {
        return getFromConsole(String.format("%s [%d] ", prompt, defaultValue), fun, defaultValue);
    }

    public static int getInteger(String prompt) {
        return getFromConsole(prompt, n -> n > 0);
    }

    public static String getString(String prompt) {
        System.out.print(prompt);

        return scannerIn.nextLine();
    }

    public static String getString(String prompt, Predicate<String> fun) {
        while (true) {
            System.out.print(prompt);
            var s = scannerIn.nextLine();

            if (fun.test(s)) {
                return s;
            }

            System.out.print("Ошибка! ");
        }
    }

    private static int getFromConsole(String prompt, Predicate<Integer> fun) {
        while (true) {
            System.out.print(prompt);
            try {
                var n = Integer.parseInt(scannerIn.nextLine());

                if (fun.test(n)) {
                    return n;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Ошибка! ");
        }
    }

    private static int getFromConsole(String prompt, Predicate<Integer> fun, int defaultValue) {
        while (true) {
            System.out.print(prompt);
            try {
                String s = scannerIn.nextLine();

                if (s.isBlank())
                    return defaultValue;

                var n = Integer.parseInt(s);

                if (fun.test(n)) {
                    return n;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.print("Ошибка! ");
        }
    }
}
