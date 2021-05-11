package com.devz.coding.bootcamp.problem2;

import com.devz.coding.bootcamp.common.Graph;

import java.util.Map;
import java.util.Set;

public class DFS {

    public boolean getPathByDFS(final String from, final String to, Set<String> visited, final Graph graph) {
        if(from.equals(to))
            return true;

        var fromNode = graph.getChildren(from);

        for (Map.Entry<String, Integer> entry : fromNode.entrySet()) {
            if(visited.contains(entry.getKey()))
                continue;

            visited.add(entry.getKey());

            if(getPathByDFS(entry.getKey(), to, visited, graph)) {
                return true;
            }
        }

        return false;
    }
}
