package com.devz.coding.bootcamp.problem2;

import java.util.*;

public class Graph {
    public final Map<String, Map<String, Integer>> nodes;

    public Graph() {
        nodes =  new HashMap<>();
    }

    public void addNode(final String value, final Map<String, Integer> children) {
        nodes.put(value, children);
    }

    public boolean getPathByDFS(final String from, final String to, Set<String> visited) {
        if(from.equals(to))
            return true;

        var fromNode = nodes.get(from);

        for (Map.Entry<String, Integer> entry : fromNode.entrySet()) {
            if(visited.contains(entry.getKey()))
                continue;

            visited.add(entry.getKey());

            if(getPathByDFS(entry.getKey(), to, visited)) {
                return true;
            }
        }

        return false;
    }
}
