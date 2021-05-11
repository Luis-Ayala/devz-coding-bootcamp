package com.devz.coding.bootcamp.problem1;

import com.devz.coding.bootcamp.common.HeapMin;
import com.devz.coding.bootcamp.common.MinHeap;
import com.devz.coding.bootcamp.common.HeapNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapMinMinSortTest {

    private final static int[] array = { 12, 11, 13, 5, 6, 7 };

    @Test
    public void sort() {
        int[] sorted = HeapMin.build(array);
        //assertArrayEquals(new int[] { 5, 6, 7, 11, 12, 13 }, sorted);

        HeapNode[] array2 = { new HeapNode("12", 12), new HeapNode("11", 11), new HeapNode("13", 13),
                new HeapNode("1", 1), new HeapNode("6", 6), new HeapNode("7", 7) };


        HeapNode[] sorted2 = MinHeap.build(array2);
        System.out.println(sorted2);




    }

    @Test
    public void getFirstValues() {
        int[] sorted = HeapMin.build(array);
        HeapMinKValues heapMinKValues = new HeapMinKValues();
        final int[] values = heapMinKValues.getFirstValues(sorted,4);
        assertArrayEquals(new int[] { 5, 6, 7, 11 }, values);
    }
}