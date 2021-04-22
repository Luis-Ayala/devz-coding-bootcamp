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

    public MyLinkedList sum(MyLinkedList linkedList) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        MyLinkedList sum = new MyLinkedList();

        Node currNode = this.head;
        while(currNode != null) {
            sb1.append(currNode.value);
            currNode = currNode.next;
        }

        currNode = linkedList.head;
        while(currNode != null) {
            sb2.append(currNode.value);
            currNode = currNode.next;
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
