package com.devz.coding.bootcamp.problem3;

import com.devz.coding.bootcamp.common.Graph;
import com.devz.coding.bootcamp.common.MinHeap;
import com.devz.coding.bootcamp.common.HeapNode;

import java.util.*;

public class Dijkstra {

    private final static Graph graph = new Graph();

    public static void main(String... arg) {
        graph.addNode("A", Map.of("B", 16, "C", 10, "D", 5));
        graph.addNode("B", Map.of("G", 6, "F", 4, "C", 2));
        graph.addNode("C", Map.of("B", 2, "F", 12, "E", 10, "D", 4));
        graph.addNode("D", Map.of("C", 4, "E", 15));
        graph.addNode("E", Map.of("F", 3, "Z", 5));
        graph.addNode("F", Map.of("G", 8, "Z", 16, "E", 3));
        graph.addNode("G", Map.of("F", 8, "Z", 7));
        graph.addNode("Z", Map.of());

        final Deque<HeapNode> path = ShortestPath("A", "Z");
        System.out.println(path);

    }

    public static Deque<HeapNode> ShortestPath(String from, String to) {
        // visited node list
        final Set<String> visited = new HashSet<>();
        // path from x to y node
        final Deque<HeapNode> path = new ArrayDeque<>();
        // starts with "from" node, creat a heap min
        MinHeap.build(new HeapNode[] { new HeapNode(from, 0) });
        while (!MinHeap.isEmpty()) {
            // take the minimum cost
            HeapNode current = MinHeap.extractMin();
            // if null then there are not more nodes to process return the path.
            if(current == null)
                return path;

            // if current is visited then process the next node in the heap
            if(visited.contains(current.getValue()))
                continue;

            // if the current node (from) is equals destiny (to) push the current node into de stack and return the path.
            if(current.getValue().equals(to)) {
                path.push(current);
                return path;
            }

            // add the current node to visited "list" and add the current node into the path
            visited.add(current.getValue());
            path.push(current);

            // gets the children of the current node, add the current cost to each child node.
            // in order to save the total cost of the path.
            final HeapNode[] heapNodes = graph.getChildren(current.getValue()).entrySet().stream()
                    .map(e -> new HeapNode(e.getKey(), e.getValue() + current.getCost()))
                    .toArray(HeapNode[]::new);

            // with the children build a new heap min.
            MinHeap.build(heapNodes);
        }

        return path;
    }
}
