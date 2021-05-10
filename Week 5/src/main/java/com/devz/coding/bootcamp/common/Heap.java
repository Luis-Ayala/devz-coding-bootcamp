package com.devz.coding.bootcamp.common;

public class Heap {
    public final int[] array;
    public int tail;

    public Heap(int capacity) {
        array = new int[capacity];
        tail = 0;
    }

    public int[] getFirstValues(final int k) {
        if(k > array.length)
            throw new ArrayIndexOutOfBoundsException();

        int[] result = new int[k];
        System.arraycopy(array, 0, result, 0, k);
        return result;
    }
}
