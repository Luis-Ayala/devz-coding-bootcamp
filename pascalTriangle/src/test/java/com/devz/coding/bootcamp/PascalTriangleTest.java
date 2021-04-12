package com.devz.coding.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PascalTriangleTest {
    private static PascalTriangle pascal = null;

    @BeforeAll
    public static void initTest() {
        pascal = new PascalTriangle();
    }

    @Test
    public void getRowCoefficientsTest() {
        final Integer[] coefficients4 = pascal.getRowCoefficients(4);
        final Integer[] coefficients10 = pascal.getRowCoefficients(10);
        final Integer[] coefficients21 = pascal.getRowCoefficients(21);

        Assertions.assertArrayEquals(new Integer[] { 1, 4, 6, 4, 1 }, coefficients4);
        Assertions.assertArrayEquals(new Integer[] { 1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1 }, coefficients10);
        Assertions.assertArrayEquals(new Integer[] { 1, 21, 210, 1330, 5985, 20349, 54264, 116280, 203490, 293930, 352716, 352716, 293930, 203490, 116280, 54264, 20349, 5985, 1330, 210, 21, 1 }, coefficients21);
    }
}