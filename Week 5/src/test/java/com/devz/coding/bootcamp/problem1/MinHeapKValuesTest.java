package com.devz.coding.bootcamp.problem1;

import com.devz.coding.bootcamp.common.MinHeap;
import com.devz.coding.bootcamp.common.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapKValuesTest {

    private final static Node[] array = { new Node("12", 12), new Node("11", 11),
            new Node("13", 13), new Node("5", 5),
            new Node("6", 6), new Node("7", 7) };

    @Test
    public void sort() {
        final Node[] sorted = MinHeap.build(array);
        final Node[] expected = { new Node("5", 5), new Node("6", 6),
                new Node("7", 7), new Node("11", 11),
                new Node("12", 12), new Node("13", 13) };

        assertArrayEquals(expected, sorted);
    }

    @Test
    public void getFirstValues() {
        Node[] sorted = MinHeap.build(array);
        MinHeapKValues heapMinKValues = new MinHeapKValues();
        final Node[] values = heapMinKValues.getFirstValues(sorted,4);

        final Node[] expected = { new Node("5", 5), new Node("6", 6),
                new Node("7", 7), new Node("11", 11) };

        assertArrayEquals(expected, values);
    }
}