package com.devz.coding.bootcamp.stack;

import com.devz.coding.bootcamp.AbstractDataStructure;
import com.devz.coding.bootcamp.Node;

public class Stack extends AbstractDataStructure {
    // The last added node.
    public Node top;
    private Node minVal;

    public Stack() {
    }

    /**
     * Add a new value at the top of the stack
     * @param data The data for the new node.
     */
    public void push(int data) {
        Node node = new Node(data);

        node.next = top;
        top = node;

        if(minVal == null || top.data <= minVal.data) {
            final Node newMin = new Node(top.data);
            newMin.next = minVal;
            minVal = newMin;
        }
    }

    /**
     * Remove the last value (top)
     */
    public Integer pop() {
        if(top == null)
            return null;

        if(top.data == minVal.data)
            minVal = minVal.next;

        top = top.next;

        return top == null ? null : top.data;
    }

    /**
     * Gets the last value (top) without remove it
     * @return Integer the last added node.
     */
    public Integer peek() {
        return top == null ? null : top.data;
    }

    /**
     * Gets the min value of the stack.
     * @return Integer Min value of the stack.
     */
    public Integer getMin() {
        return minVal == null ? null : minVal.data;
    }

    /**
     * Print the stack. The top is the leftmost value
     */
    public void print() {
        final StringBuilder sb = new StringBuilder();
        Node iterator = top;
        while(iterator != null) {
            sb.append(iterator.data).append(", ");
            iterator = iterator.next;
        }

        if(sb.length() > 0)
            System.out.println("[" + sb.substring(0, sb.length() - 2) + "]");
        else
            System.out.println("[]");

        System.out.println();
    }
}
