package com.devz.coding.bootcamp.common;

import java.util.Objects;

public class Node {
    private final String value;
    private final Integer cost;

    public Node(String value, Integer cost) {
        this.value = value;
        this.cost = cost;
    }

    public String getValue() {
        return value;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Value: " + value + ", Cost: " + cost;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Node)) return false;
        Node node = (Node) obj;

        return Objects.equals(value, node.value);
    }
}
