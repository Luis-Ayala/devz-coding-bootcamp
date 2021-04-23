package com.devz.coding.bootcamp;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedList {
    private final Set<Node> visited = new HashSet<>();
    private Node head = null;

    public void clear() {
        this.head = null;
        this.visited.clear();
    }

    public Node addNode(final int value) {
        final Node node = new Node(value);

        if (head == null) {
            head = new Node(value);
            return node;
        }

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = node;

        return node;
    }

    public Node addNode(final int value, final Node next) {
        final Node node = new Node(value);
        node.next = next;

        if (head == null) {
            head = new Node(value);
            return node;
        }

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = node;

        return node;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(final int value) {
            this.value = value;
        }
    }

    public boolean hasCycle() {
        Node currNode = head;
        while (currNode != null) {
            if(visited.contains(currNode.next)) {
                return true;
            }

            visited.add(currNode);
            currNode = currNode.next;
        }

        return false;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Node currNode = head;
        while(currNode != null) {
            sb.append(currNode.value);
            if(currNode.next != null)
                sb.append("->");

            currNode = currNode.next;
        }
        return sb.toString();
    }
}
