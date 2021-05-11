package com.devz.coding.bootcamp.common;

public class MinHeap {
    private static  HeapNode[] array;
    private static int tail;

    public MinHeap() {
    }

    public static HeapNode[] build(final HeapNode[] input) {
        array = new HeapNode[input.length];
        System.arraycopy(input, 0, array, 0, input.length);
        tail = input.length;

        minHeapify();
        return array;
    }

    private static void minHeapify() {
        final int lastNotLeaf = parentIndex(tail - 1);
        for(int index = lastNotLeaf; index >= 0; index--) {
            heapify(array, tail, index);
        }

        sortHeap();
    }

    public static boolean isEmpty() {
        return array == null || array.length == 0;
    }

    public static HeapNode extractMin() {
        if(array == null || array.length == 0)
            return null;

        HeapNode min = getMin();
        tail--;
        array[0] = array[tail];
        array[tail] = null;
        minHeapify();
        return min;
    }

    private static HeapNode getMin() {
        if(array == null || array.length == 0)
            return null;

        return array[0];
    }

    private static void sortHeap() {
        for(int index = tail - 1; index > 0; index--) {
            HeapNode swap = array[0];
            array[0] = array[index];
            array[index] = swap;

            heapify(array, index,0);
        }
    }

    private static void heapify(final HeapNode[] array, final int size, final int currentIndex) {
        int root = currentIndex;
        final int rightChildIndex = rightChildIndex(currentIndex);
        final int leftChildIndex = leftChildIndex(currentIndex);

        if(hasRightChild(currentIndex, size) && array[rightChildIndex].getCost()  > array[root].getCost()) {
            root = rightChildIndex;
        }

        if(hasLeftChild(currentIndex, size) && array[leftChildIndex].getCost() > array[root].getCost()) {
            root = leftChildIndex;
        }

        if(root != currentIndex) {
            HeapNode swap = array[currentIndex];
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
