package com.devz.coding.bootcamp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    public void twoSum() {
        final int[] expected1 = new int[] { 0, 1 };
        final int[] expected2 = new int[] { 1, 3 };

        Assertions.assertArrayEquals(expected1, TwoSum.twoSum(new int[] { 2, 7, 1, 5 }, 9));
        Assertions.assertArrayEquals(expected2, TwoSum.twoSum(new int[] { 3, -1, 0, 1 }, 0));
    }
}