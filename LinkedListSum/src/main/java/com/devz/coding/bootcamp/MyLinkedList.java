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

    public MyLinkedList sum(final MyLinkedList linkedList) {
        final StringBuilder sb1 = new StringBuilder();
        final StringBuilder sb2 = new StringBuilder();
        final MyLinkedList sum = new MyLinkedList();

        Node thisCurrNode = this.head;
        Node thatCurrNode = linkedList.head;

        while(thisCurrNode != null || thatCurrNode != null) {
            if(thisCurrNode != null) {
                sb1.append(thisCurrNode.value);
                thisCurrNode = thisCurrNode.next;
            }

            if(thatCurrNode != null) {
                sb2.append(thatCurrNode.value);
                thatCurrNode = thatCurrNode.next;
            }
        }

        int sumAsInt = Integer.parseInt(sb1.reverse().toString()) + Integer.parseInt(sb2.reverse().toString());

        char[] sumAsArray = Integer.toString(sumAsInt).toCharArray();

        for(int index = sumAsArray.length - 1; index >=0; index--) {
            sum.addNode(Integer.parseInt(String.valueOf(sumAsArray[index])));
        }

        return sum;
    }

    private static class Node {
        public int value;
        public Node next;

        public Node(final int value) {
            this.value = value;
        }

        public Node(final int value, final Node next) {
            this.value = value;
            this.next = next;
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
