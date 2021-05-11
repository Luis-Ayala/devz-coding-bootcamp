package com.devz.coding.bootcamp.problem3;

import com.devz.coding.bootcamp.common.Graph;
import com.devz.coding.bootcamp.common.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    private static Graph graph;

    @BeforeAll
    public static void createGraph() {
        graph = new Graph();
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
    void shortestPath() {
        final Deque<Node> path = Dijkstra.shortestPath(graph, "A", "Z");
        final Node last = path.peek();

        assertEquals(23, last.getCost());
        assertEquals("Z", last.getValue());
    }
}