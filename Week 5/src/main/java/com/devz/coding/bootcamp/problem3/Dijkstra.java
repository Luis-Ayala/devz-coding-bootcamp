package com.devz.coding.bootcamp.problem3;

import com.devz.coding.bootcamp.common.Graph;
import com.devz.coding.bootcamp.common.MinHeap;
import com.devz.coding.bootcamp.common.Node;

import java.util.*;

public class Dijkstra {

    public static Deque<Node> shortestPath(final Graph graph, final String from, final String to) {
        // visited node list
        final Set<String> visited = new HashSet<>();
        // path from x to y node
        final Deque<Node> path = new ArrayDeque<>();
        // starts with "from" node, creat a heap min
        MinHeap.build(new Node[] { new Node(from, 0) });
        while (!MinHeap.isEmpty()) {
            // take the minimum cost
            Node current = MinHeap.extractMin();
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
            final Node[] nodes = graph.getChildren(current.getValue()).entrySet().stream()
                    .map(e -> new Node(e.getKey(), e.getValue() + current.getCost()))
                    .toArray(Node[]::new);

            // with the children build a new heap min.
            MinHeap.build(nodes);
        }

        return path;
    }
}
