package com.devz.coding.bootcamp.common;

import java.util.Objects;

public class HeapNode {
    private final String value;
    private final Integer cost;

    public HeapNode(String value, Integer cost) {
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
}
