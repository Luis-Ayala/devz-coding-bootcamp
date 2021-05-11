package com.devz.coding.bootcamp.problem2;

import com.devz.coding.bootcamp.common.Graph;
import com.devz.coding.bootcamp.common.Node;

import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class DFS {

    public boolean getPathByDFS(final String from, final String to, Set<String> visited,
                                final Graph graph, final Deque<String> path) {
        if(from.equals(to))
            return true;

        Map<String, Integer> fromNode = graph.getChildren(from);

        for (Map.Entry<String, Integer> entry : fromNode.entrySet()) {
            if(visited.contains(entry.getKey()))
                continue;

            visited.add(entry.getKey());
            path.push(entry.getKey());

            if(getPathByDFS(entry.getKey(), to, visited, graph, path)) {
                return true;
            }
        }

        return false;
    }
}
