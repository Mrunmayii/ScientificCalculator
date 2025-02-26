package com.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testSquareRoot() {
        assertEquals(5.0, Calculator.squareRoot(25), 0.0001);
    }
}
