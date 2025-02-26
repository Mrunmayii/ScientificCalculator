package com.calculator;

public class Calculator {

    public static double squareRoot(double number) {
        if (number < 0) throw new IllegalArgumentException("Please enter positive number");
        return Math.sqrt(number);
    }

    public static long factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Please enter positive number");
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double logarithm(double number) {
        if (number <= 0) throw new IllegalArgumentException("Log is undefined for non-positive numbers");
        return Math.log(number);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
