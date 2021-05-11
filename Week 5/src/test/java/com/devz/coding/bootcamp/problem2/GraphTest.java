package com.devz.coding.bootcamp.problem2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {

    private final static Graph graph = new Graph();

    @BeforeAll
    public static void build() {
        graph.addNode("A", Map.of("B", 16, "C", 10, "D", 5));
        graph.addNode("B", Map.of("G", 6, "F", 4, "C", 2));
        graph.addNode("C", Map.of("B", 2, "F", 12, "E", 10, "D", 4));
        graph.addNode("D", Map.of("C", 4, "E", 15));
        graph.addNode("E", Map.of("F", 3, "Z", 5));
        graph.addNode("F", Map.of("G", 8, "Z", 16, "E", 3));
        graph.addNode("G", Map.of("F", 8, "Z", 7));
        graph.addNode("Z", Map.of());
    }

    @Test
    public void getPathByDFS() {
        List<String> starts = new ArrayList<>();
        starts.add("B");
        starts.add("C");
        starts.add("D");

        Set<String> visited = new HashSet<>();
        boolean hasPath = graph.getPathByDFS("A", "Z", visited);

        assertTrue(hasPath);
        assertFalse(visited.isEmpty());
        assertEquals("Z", visited.toArray()[visited.size() - 1]);
        assertTrue(starts.contains(visited.toArray(new String[0])[0]));
    }
}