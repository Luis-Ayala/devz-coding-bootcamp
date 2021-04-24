package om.devz.coding.bootcamp;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedList {
    private final Set<Node> visited = new HashSet<>();
    private Node head = null;

    public void clear() {
        this.head = null;
        this.visited.clear();
    }


    public void reverse() {
        if(head != null) {
            Node tmp;
            Node prevNode = this.head;
            Node currNode = this.head.next;

            while (currNode != null) {
                tmp = currNode.next;

                if(prevNode.equals(head)) {
                    prevNode.next = null;
                }

                currNode.next = prevNode;
                prevNode = currNode;
                currNode = tmp;
            }
            head = prevNode;
        }
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

    public static class Node {
        public int value;
        public Node next;

        public Node(final int value) {
            this.value = value;
        }
    }

    public void printLikedList() {
        final StringBuilder sb = new StringBuilder();
        Node currNode = head;
        while(currNode != null) {
            sb.append(currNode.value);
            if(currNode.next != null)
                sb.append("->");

            currNode = currNode.next;
        }
        System.out.println(sb);
    }
}
