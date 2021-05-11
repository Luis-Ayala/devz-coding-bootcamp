package com.devz.coding.bootcamp.problem1;

import com.devz.coding.bootcamp.common.Node;

public class MinHeapKValues {

    public MinHeapKValues() {
    }

    public Node[] getFirstValues(final Node[] array, final int k) {
        if(k > array.length)
            throw new ArrayIndexOutOfBoundsException();

        Node[] result = new Node[k];
        System.arraycopy(array, 0, result, 0, k);
        return result;
    }
}
