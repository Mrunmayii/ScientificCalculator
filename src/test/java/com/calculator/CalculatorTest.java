package com.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();




    @Test
    public void testSquareRoot() {
        assertEquals(5.0, calculator.squareRoot(25), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-1));
    }
    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(6, calculator.factorial(3));
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-5));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, calculator.logarithm(1), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> calculator.logarithm(0));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, calculator.power(2, 3), 0.0001);
        assertEquals(0.5, calculator.power(2, -1), 0.001);
    }
}
