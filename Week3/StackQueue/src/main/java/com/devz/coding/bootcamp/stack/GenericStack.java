package com.devz.coding.bootcamp.stack;

public class GenericStack<T> {
    // The last added node.
    public Node<T> top;
    public int size;

    public void push(T data) {
        Node<T> node = new Node<>(data);

        node.next = top;
        top = node;
        size++;
    }

    public T pop() {
        if(top == null)
            return null;

        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        return top == null ? null : top.data;
    }

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(final T data) {
            this.data = data;
            this.next = null;
        }
    }

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
