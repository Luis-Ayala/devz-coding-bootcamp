package com.devz.coding.bootcamp;

public class MyLinkedList {
    private Node head = null;

    public MyLinkedList addNode(final int value) {
        final Node node = new Node(value);

        if(head == null) {
            head = new Node(value);
            return this;
        }

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = node;

        return this;
    }

    public Integer getKNodeBeforeEnd(int k) {
        Node currNode = head;
        Node nextKNode = head;

        int count = 0;
        while (nextKNode != null) {
            nextKNode = nextKNode.next;
            count++;

            if(count > k + 1)
                currNode = currNode.next;
        }

        return currNode.value;
    }

    private static class Node {
        public int value;
        public Node next;

        public Node(final int value) {
            this.value = value;
        }
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
