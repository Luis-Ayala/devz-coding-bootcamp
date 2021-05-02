package com.devz.coding.bootcamp.queue;

import com.devz.coding.bootcamp.AbstractDataStructure;
import com.devz.coding.bootcamp.Node;
import com.devz.coding.bootcamp.stack.Stack;

public class Queue extends AbstractDataStructure {

    private Stack stack1 = new Stack();
    private final Stack stack2 = new Stack();

    /**
     * Push element x to the back of queue.
     */
    @Override
    public void push(int data) {
        final Node node = new Node(data);

        if (stack1.top == null) {
            stack1.top = node;
            return;
        }

        Node iterator = stack1.top;
        while (iterator.next != null)
            iterator = iterator.next;

        iterator.next = node;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     * @return Integer the element from in front of queue.
     */
    @Override
    public Integer pop() {
        final int retValue = stack1.top.data;
        stack2.top = stack1.top.next;

        Node currentNode = stack2.top;
        stack1 = new Stack();
        while(currentNode != null) {
            push(currentNode.data);
            currentNode = currentNode.next;
        }

        return retValue;
    }

    /**
     * Get the front element.
     * @return Integer the front element
     */
    @Override
    public Integer peek() {
        return stack1.top.data;
    }

    /**
     * Returns whether the queue is empty.
     * @return true if yhe queue is empty, false otherwise.
     */
    public boolean empty() {
        return stack1 == null || stack1.top == null;
    }

    @Override
    public void print() {
        final StringBuilder sb = new StringBuilder();
        Node iterator = stack1.top;
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
