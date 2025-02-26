package com.calculator;

public class Calculator {

    public static double squareRoot(double number) {
        if (number < 0) throw new IllegalArgumentException("Negative number not allowed");
        return Math.sqrt(number);
    }

}
