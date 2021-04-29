package com.devz.coding.bootcamp;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    private final Set<Node> visited = new HashSet<>();
    private Node head;

    public static class Node {
        int data;
        Node next;

        public Node(final int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Print the linked list i -> j -> k ->...
     */
    public void print() {
        if(head == null)
            System.out.println("NULL");

        if(hasCycleReference()) {
            System.out.println("The linked list has a cycle reference.");
            return;
        }

        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data);
            if(currentNode.next != null)
                System.out.print("->");

            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * Add a new node to the end of the linked list
     *
     * @param newData The new element to add to the linked list.
     * @return The new node added.
     */
    public Node append(int newData) {
        return append(newData, null);
    }

    public Node append(final int newData, final Node next) {
        final Node node = new Node(newData);
        if(next != null)
            node.next = next;

        if (head == null) {
            head = node;
            return head;
        }

        Node currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;

        currentNode.next = node;

        return head;
    }

    /**
     * For insert(i, v), there are four (legal) possibilities, i.e. item v is added to:
     *
     *     The head (before the current first item) of the linked list, i = 0,
     *     An empty linked list (which fortunately similar to the previous case),
     *     The position beyond the last (the current tail) item of the linked list, i = N,
     *     The other positions of the linked list, i = [1..N-1].
     * @param atIndex Integer index to insert the new node.
     * @param data Data for the new node.
     */
    public void insert(final int atIndex, final int data) {
        int count = 0;
        final Node newNode = new Node(data);

        // An empty linked list
        if(head == null) {
            head = newNode;
            return;
        }

        // The head (before the current first item) of the linked list
        if(atIndex == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Move te pointer (currentNode) to the N-1 position
        Node currentNode = head;
        while(count != atIndex - 1 && currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }

        // Validate the position beyond the last.
        // If it is a valid index then move pointers i = [1..N-1].
        if(currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = newNode;
            newNode.next = next;
        }
    }

    /**
     * For remove(i), there are three (legal) possibilities, i.e. index i is:
     *
     *     The head (the current first item) of the linked list, i = 0, it affects the head pointer
     *     The tail of the linked list, i = N-1, it affects the tail pointer
     *     The other positions of the linked list, i = [1..N-2].
     * @param atIndex Remove node at index.
     */
    public void remove(final int atIndex) {
        int count = 0;

        // Validate if the head is null, do nothing
        if(head == null)
            return;

        // If we want removed the head but there is only one node (only head)
        if(atIndex == 0 && head.next == null) {
            head = null;
            return;
        }

        // Remove the head
        if(atIndex == 0)
            head = head.next;

        // Try to get the node i-1 (atIndex - 1)
        Node previousNode = head;
        while(count != atIndex - 1 && previousNode != null) {
            previousNode = previousNode.next;
            count++;
        }

        // Validate the index, if index > linked list's length the index is invalid, do nothing.
        if(previousNode == null)
            return;

        // Move the pointers.
        previousNode.next = previousNode.next.next;
    }

    /**
     * Problem #1
     *
     * Escribe un programa borre elementos duplicados de un Linked List.
     *
     * In:
     * 4 → 5 → 9 → 0 → 5 → 1 → 2
     * Out:
     * 4 → 5 → 9 → 0 → 1 → 2
     */
    public void removeDuplicates() {
        final Set<Integer> cache = new HashSet<>();
        Node prevNode = head;
        Node currNode = head;
        while(currNode.next != null) {
            if(! cache.contains(currNode.data)) {
                cache.add(currNode.data);
                prevNode = currNode;
                currNode = currNode.next;
                continue;
            }

            prevNode.next = currNode.next;
            prevNode = currNode;
            currNode = currNode.next;

        }
    }

    /**
     * Problem #2
     *
     * Tienes dos números representados por dos linked lists donde el valor de cada nodo
     * representa un dígito. Los dígitos están guardados de manera inversa, de manera
     * que las unidades está en el primer nodo (head), las decenas en el segundo nodo, etc.
     *
     * Escribe un programa que dado dos linked lists, sume los dos números que
     * representan y regrese esa suma representada también en un linked list.
     *
     * In:
     * a: 2 → 3 → 1
     * b: 6 → 0 → 3
     * Equivale a 132 + 306
     *
     * Out:
     * resultado: 8 → 3 → 4
     * Equivale a 438
     *
     * @param list A second Linked list to perform the sum
     * @return A Linked list with the result.
     */
    public LinkedList sum(LinkedList list) {
        final LinkedList result = new LinkedList();

        final int base10 = 10;
        int position = 0;
        int multiplicand;

        int sum = 0;

        Node thisCurrNode = this.head;
        Node thatCurrNode = list.head;

        while(thisCurrNode != null || thatCurrNode != null) {
            multiplicand = (int) Math.pow(base10, position);

            if(thisCurrNode != null) {
                sum += thisCurrNode.data * multiplicand;
                thisCurrNode = thisCurrNode.next;
            }

            if(thatCurrNode != null) {
                sum += thatCurrNode.data * multiplicand;
                thatCurrNode = thatCurrNode.next;
            }

            position++;
        }

        char[] sumAsArray = Integer.toString(sum).toCharArray();
        for(int index = sumAsArray.length - 1; index >= 0; index--) {
            result.append(Integer.parseInt(String.valueOf(sumAsArray[index])));
        }

        return result;
    }

    /**
     * Problem #3
     *
     * Implementa un algoritmo que encuentre nodo k lugares antes del último nodo.
     *
     * n: 2 → 3 → 1 → 4 → 9 → 10 → 11.
     * k = 2
     * Out: 9.
     * Hay   dos   lugares   entre   el   nodo   9   y   el   último   nodo
     *
     * @param k Integer k places before linked list's end.
     * @return the value of the k node.
     */
    public Integer getKNodeBeforeEnd(int k) {
        if(k < 0)
            throw new IllegalArgumentException("The k value has to be equals or greater than zero.");

        if(head == null)
            throw new IllegalArgumentException("The Linked lis is empty.");

        Node currNode = head;
        Node nextKNode = head;
        final int startMovingAt = k + 1;

        int count = 0;
        while (nextKNode != null) {
            nextKNode = nextKNode.next;
            count++;

            if(count > startMovingAt)
                currNode = currNode.next;
        }

        if(currNode == null)
            throw new IllegalArgumentException("The k value not found.");

        return currNode.data;
    }

    /**
     * Problem #4
     *
     * Implementa un algoritmo que borre un nodo que se encuentra dentro de un linked
     * list; éste nodo no es ni el primer ni el último nodo en la secuencia, sólo se sabe que
     * está entre esos dos.
     *
     * Nota: tu algoritmo no debe de tener acceso al nodo head, sino solo al nodo que se
     * desea borrar.
     *
     * In: Nodo "y" del Linked list: x → y → z
     * Out:  x → z
     *
     * @param node The node to remove.
     */
    public void removeNode(Node node) {
        // The linked list is empty
        if(node == null)
            return;

        // last node, can not delete without head
        if(node.next == null)
            return;

        // Next node
        Node next = node.next;
        // The next node to point
        Node nextNext = node.next.next;

        // Copy data of the next node to current node
        node.data = next.data;
        // Delete the node
        node.next = nextNext;
    }

    /**
     * Problem #5
     *
     * Dado un singly linked list, escribe un programa que invierta la dirección de dicha
     * linked list (reverse)
     * In: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10
     * Out: 10 → 9 → 8 → 7 → 6 → 5 → 4 → 3 → 2 → 1
     */
    public void reverse() {
        if(head == null)
            return;

        Node prevNode = null;
        Node currNode = this.head;

        while (currNode != null) {
            Node auxiliary = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = auxiliary;
        }
        head = prevNode;
    }

    /**
     * Problem #6
     *
     * Dado un singly linked list, escribe un programa que detecte si un linked list tiene una
     * referencia circular
     * In: 6 → 8 → 0 → 4 → 7 → 2
     *             ↑           ↓
     *             ↑           ↓
     *             10 ←  3  ←  5
     * Out: true. El nodo 10 apunta al nodo 0, lo que crea un loop.
     * @return true if the linked list has a cycle reference, false otherwise.
     */
    public boolean hasCycleReference() {
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

    /**
     * Floyd's Cycle Detection Algorithm (The Tortoise and the Hare)
     *
     * How do you determine if your singly-linked list has a cycle? In the late 1960s,
     * Robert W. Floyd invented an algorithm that worked in linear (O(N)) time.
     * It is also called Floyd's cycle detection algorithm.
     * The easiest solution to the cycle detection problem is to run through the list, keeping track of which nodes you visit,
     * and on each node check to see if it is the same as any of the previous nodes.
     * It's pretty obvious that this runs in quadratic (O(N^2)) time... not very efficient,
     * and actually more complicated than this one.
     *
     * The Tortoise and the Hare is possibly the most famous cycle detection algorithm, and is surprisingly straightforward.
     * The Tortoise and the Hare are both pointers, and both start at the top of the list. For each iteration,
     * the Tortoise takes one step and the Hare takes two. If there is a loop, the hare will go around that loop
     * (possibly more than once) and eventually meet up with the turtle when the turtle gets into the loop.
     * If there is no loop, the hare will get to the end of the list without meeting up with the turtle.
     *
     * Why can't you just let the hare go by itself? If there was a loop, it would just go forever;
     * the turtle ensues you will only take n steps at most.
     *
     * https://web.archive.org/web/20160313063357/http://www.siafoo.net/algorithm/10
     *
     * @return true if the Linked list has a cycle reference, false otherwise.
     */
    public boolean floydCycleDetection() {
        Node tortoise = head;
        Node hare = head;

        while(true) {
            if(hare == null)
                return false;

            hare = hare.next;

            if(hare == null)
                return false;

            hare = hare.next;
            tortoise = tortoise.next;

            if(hare.equals(tortoise))
                return true;
        }
    }

    /**
     * How do you determine if your singly-linked list has a cycle? In 1980, Brent invented an algorithm that not only
     * worked in linear time, but required less stepping than Floyd's Tortoise and the Hare algorithm (however it is
     * slightly more complex). Although stepping through a 'regular' linked list is computationally easy,
     * these algorithms are also used for factorization and pseudorandom number generators, linked lists are implicit
     * and finding the next member is computationally difficult.
     *
     * Brent's algorithm features a moving rabbit and a stationary, then teleporting, turtle. Both turtle and rabbit
     * start at the top of the list. The rabbit takes one step per iteration. If it is then at the same position as the
     * stationary turtle, there is obviously a loop. If it reaches the end of the list, there is no loop.
     *
     * Of course, this by itself will take infinite time if there is a loop. So every once in a while, we teleport the
     * turtle to the rabbit's position, and let the rabbit continue moving. We start out waiting just 2 steps before
     * teleportation, and we double that each time we move the turtle.
     *
     * Why move the turtle at all? Well, the loop might not include the entire list; if a rabbit gets stuck in a loop
     * further down, without the turtle, it will go forever. Why take twice as long each time? Eventually,
     * the length of time between teleportations will become longer than the size of the loop, and the turtle will be
     * there waiting for the rabbit when it gets back.
     *
     * Note that like Floyd's Tortoise and Hare algorithm, this one runs in O(N). However you're doing less stepping
     * than with Floyd's (in fact the upper bound for steps is the number you would do with Floyd's algorithm).
     * According to Brent's research, his algorithm is 24-36% faster on average for implicit linked list algorithms.
     *
     * https://web.archive.org/web/20160314064756/http://www.siafoo.net/algorithm/11
     *
     * @return true if the Linked list has a cycle reference, false otherwise.
     */
    public boolean brentCycleDetection() {
        Node tortoise = head;
        Node rabbit = head;

        int steps = 0;
        int limit = 2;

        while(true) {
            if (rabbit == null)
                return false;

            rabbit = rabbit.next;
            steps++;

            if (tortoise.equals(rabbit))
                return true;

            if (steps == limit) {
                tortoise = rabbit;
                steps = 0;
                limit *= 2;
            }
        }
    }
}
