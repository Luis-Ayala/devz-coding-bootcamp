package com.devz.coding.bootcamp.problem1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapMinSortTest {

    private final static int[] array = { 12, 11, 13, 5, 6, 7 };

    @Test
    public void sort() {
        final int[] sorted = HeapMinSort.sort(array);
        assertArrayEquals(new int[] { 5, 6, 7, 11, 12, 13 }, sorted);
    }

    @Test
    public void getFirstValues() {
        HeapMinSort.sort(array);
        final int[] values = HeapMinSort.getFirstValues(4);
        assertArrayEquals(new int[] { 5, 6, 7, 11 }, values);
    }
}