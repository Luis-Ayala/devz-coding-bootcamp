package com.devz.coding.bootcamp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    final static LinkedList cycleReference = new LinkedList();
    final static LinkedList noCycleReference = new LinkedList();

    @BeforeAll
    public static void beforeAll() {
        cycleReference.append(6);
        cycleReference.append(8);
        Node node = cycleReference.append(0);
        cycleReference.append(4);
        cycleReference.append(7);
        cycleReference.append(2);
        cycleReference.append(5);
        cycleReference.append(3);
        cycleReference.append(10, node);

        noCycleReference.append(6);
        noCycleReference.append(8);
        noCycleReference.append(0);
        noCycleReference.append(4);
        noCycleReference.append(7);
        noCycleReference.append(2);
    }

    @Test
    void removeDuplicates() {
        LinkedList list = new LinkedList();
        list.append(4);
        list.append(5);
        list.append(9);
        list.append(0);
        list.append(5);
        list.append(1);
        list.append(2);

        list.removeDuplicates();

        String result = list.toString();
        assertEquals("4->5->9->0->1->2", result);
    }

    @Test
    void sum() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.append(2);
        list1.append(3);
        list1.append(1);

        list2.append(6);
        list2.append(0);
        list2.append(3);

        LinkedList sum = list1.sum(list2);
        assertEquals("8->3->4", sum.toString());

    }

    @Test
    void getKNodeBeforeEnd() {
        LinkedList list1 = new LinkedList();

        list1.append(2);
        list1.append(3);
        list1.append(1);
        list1.append(4);
        list1.append(9);
        list1.append(10);
        list1.append(11);

        Integer result = list1.getKNodeBeforeEnd(2);
        assertEquals(9, result);
    }

    @Test
    void reverse() {
        LinkedList list1 = new LinkedList();

        list1.append(1);
        list1.append(2);
        list1.append(3);
        list1.append(4);
        list1.append(5);
        list1.append(6);
        list1.append(7);
        list1.append(8);
        list1.append(9);
        list1.append(10);

        list1.reverse();

        String result = list1.toString();
        assertEquals("10->9->8->7->6->5->4->3->2->1", result);
    }

    @Test
    void hasCycleReference() {
        boolean result = cycleReference.hasCycleReference();
        boolean noCycle = noCycleReference.hasCycleReference();

        assertTrue(result);
        assertFalse(noCycle);
    }

    @Test
    void floydCycleDetection() {
        boolean result = cycleReference.floydCycleDetection();
        boolean noCycle = noCycleReference.floydCycleDetection();

        assertTrue(result);
        assertFalse(noCycle);
    }

    @Test
    void brentCycleDetection() {
        boolean result = cycleReference.brentCycleDetection();
        boolean noCycle = noCycleReference.brentCycleDetection();

        assertTrue(result);
        assertFalse(noCycle);
    }
}
