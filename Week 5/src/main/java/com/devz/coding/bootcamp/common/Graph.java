package com.devz.coding.bootcamp.common;

import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> nodes;

    public Graph() {
        nodes =  new HashMap<>();
    }

    public void addNode(final String value, final Map<String, Integer> children) {
        nodes.put(value, children);
    }

    public Map<String, Integer> getChildren(final String node) {
        return nodes.get(node);
    }
}
