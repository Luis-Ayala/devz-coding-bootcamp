package com.devz.coding.bootcamp.problem1;

import com.devz.coding.bootcamp.common.Heap;

public class HeapMinSort {
    private static Heap heap;

    private HeapMinSort() {
    }

    public static int[] sort(final int[] input) {
        heap = new Heap(input.length);
        System.arraycopy(input, 0, heap.array, 0, input.length);
        heap.tail = input.length;

        final int lastNotLeaf = parentIndex(heap.tail - 1);
        for(int index = lastNotLeaf; index >= 0; index--) {
            heapify(heap, heap.tail, index);
        }

        sortHeap(heap);
        return heap.array;
    }

    public static int[] getFirstValues(final int k) {
        return heap == null ? new int[0] : heap.getFirstValues(k);
    }

    private static void sortHeap(final Heap heap) {
        for(int index = heap.tail - 1; index > 0; index--) {
            int swap = heap.array[0];
            heap.array[0] = heap.array[index];
            heap.array[index] = swap;

            heapify(heap, index,0);
        }
    }

    private static void heapify(final Heap heap, final int size, final int currentIndex) {
        int root = currentIndex;
        final int rightChildIndex = rightChildIndex(currentIndex);
        final int leftChildIndex = leftChildIndex(currentIndex);

        if(hasRightChild(currentIndex, size) && heap.array[rightChildIndex] > heap.array[root]) {
            root = rightChildIndex;
        }

        if(hasLeftChild(currentIndex, size) && heap.array[leftChildIndex] > heap.array[root]) {
            root = leftChildIndex;
        }

        if(root != currentIndex) {
            int swap = heap.array[currentIndex];
            heap.array[currentIndex] = heap.array[root];
            heap.array[root] = swap;

            heapify(heap, size, root);
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
