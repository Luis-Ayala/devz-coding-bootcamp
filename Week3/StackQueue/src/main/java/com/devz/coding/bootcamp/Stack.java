package com.devz.coding.bootcamp;

public class Stack {
    // The last added node.
    private Node head;
    private Node minVal;

    public Stack() {
        head = null;
        minVal = null;
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(final int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Remueve el último valor insertado
     */
    public void pop() {
        if(isEmpty())
            return;

        if(head.data == minVal.data)
            minVal = minVal.next;

        head = head.next;
    }

    /**
     * Agrega un nuevo valor “arriba” del stack.
     * @param data The data for the new node.
     */
    public void push(int data) {
        final Node node = new Node(data);

        node.next = head;
        head = node;

        if(minVal == null || head.data <= minVal.data) {
            final Node newMin = new Node(head.data);
            newMin.next = minVal;
            minVal = newMin;
        }
    }

    /**
     * Regresa el último valor insertado (sin borrarlo)
     * @return Gets the last added node without remove it.
     */
    public Integer peek() {
        if(isEmpty())
            return null;

        return head.data;
    }

    /**
     * Gets the min value of the stack.
     * @return Integer Min value of the stack.
     */
    public Integer getMin() {
        if(minVal == null)
            return null;

        return minVal.data;
    }

    /**
     * Regresa true si la pila está vacía
     * @return true if the stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Print the stack i -> j -> k ->...
     */
    public void print() {
        if(head == null)
            System.out.println("NULL");

        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data);
            if(currentNode.next != null)
                System.out.print("->");

            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
