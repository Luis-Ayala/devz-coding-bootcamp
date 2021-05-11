package com.devz.coding.bootcamp.common;

public class HeapMin {
    private static int[] array;
    private static int tail;

    private HeapMin() {
    }

    public static int[] build(final int[] input) {
        array = new int[input.length];
        System.arraycopy(input, 0, array, 0, input.length);
        tail = input.length;

        final int lastNotLeaf = parentIndex(tail - 1);
        for(int index = lastNotLeaf; index >= 0; index--) {
            heapify(array, tail, index);
        }

        sortHeap();
        return array;
    }

    public int extractMin() {
        return array[0];
    }

    private static void sortHeap() {
        for(int index = tail - 1; index > 0; index--) {
            int swap = array[0];
            array[0] = array[index];
            array[index] = swap;

            heapify(array, index,0);
        }
    }

    private static void heapify(final int[] array, final int size, final int currentIndex) {
        int root = currentIndex;
        final int rightChildIndex = rightChildIndex(currentIndex);
        final int leftChildIndex = leftChildIndex(currentIndex);

        if(hasRightChild(currentIndex, size) && array[rightChildIndex] > array[root]) {
            root = rightChildIndex;
        }

        if(hasLeftChild(currentIndex, size) && array[leftChildIndex] > array[root]) {
            root = leftChildIndex;
        }

        if(root != currentIndex) {
            int swap = array[currentIndex];
            array[currentIndex] = array[root];
            array[root] = swap;

            heapify(array, size, root);
        }
    }

    private static int parentIndex(final int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    private static int rightChildIndex(final int currentIndex) {
        return currentIndex * 2 + 2;
    }

    private static int leftChildIndex(final int currentIndex) {
        return currentIndex * 2 + 1;
    }

    private static boolean hasRightChild(final int currentIndex, final int size) {
        return rightChildIndex(currentIndex) < size;
    }

    private static boolean hasLeftChild(final int currentIndex, final int size) {
        return leftChildIndex(currentIndex) < size;
    }
}
