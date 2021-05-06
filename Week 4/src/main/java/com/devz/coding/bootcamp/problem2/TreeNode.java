package com.devz.coding.bootcamp.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNode {
    public HashMap<Employee, TreeNode> children;

    public TreeNode() {
        this.children = new HashMap<>();
    }

    public TreeNode(Integer... children) {
        this.children = new HashMap<>();
        Arrays.stream(children).forEach(child -> {
            this.children.put(new Employee(child), new TreeNode());
        });

    }

    @Override
    public String toString() {
        final List<String> key = new ArrayList<>(this.children.size());
        key.addAll(this.children.keySet().stream().map(String::valueOf).collect(Collectors.toList()));
        final String keys = String.join(", ", key.toArray(new String[0]));

        return "[" + "children: " + keys + "]";
    }
}
