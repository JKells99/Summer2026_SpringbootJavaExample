package com.keyin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
//        Assertions.assertEquals(5, calc.add(2, 3));
        Assertions.assertNotEquals(5,calc.add(10,2));
        Assertions.assertEquals(5,calc.add(2,3));
    }
    @Test
    public void testDivide() {
        Assertions.assertEquals(2, calc.divide(4, 2));
    }
    @Test
    public void testMultiply() {
        Assertions.assertEquals(12, calc.multiply(3, 4));
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.divide(4, 0));
    }

    @Test
    void testAssertNotThrows() {
        Assertions.assertDoesNotThrow(() -> calc.divide(4, 2));


    }

    @Test
    void testAssertThrows() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.divide(0, 2));
    }
}
