package com.serenitydojo.calculator;

import java.util.Locale;

public class Calculator {

    private Locale locale;

    public Calculator(Locale locale) {
        this.locale = locale;
    }

    public Calculator() {
        this(Locale.getDefault());
    }

    public int add(int... args) {
        int sum = 0;
        for(int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
