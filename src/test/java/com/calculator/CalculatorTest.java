package com.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testSquareRoot() {
        assertEquals(5.0, Calculator.squareRoot(25), 0.0001);
    }
    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
        assertEquals(6, Calculator.factorial(3));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, Calculator.logarithm(1), 0.0001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2, 3), 0.0001);
    }
}
