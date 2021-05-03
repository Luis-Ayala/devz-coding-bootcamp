package com.devz.coding.bootcamp.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean isCompleteWord;
    public String word;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isCompleteWord = false;
        this.word = null;
    }

    @Override
    public String toString() {
        final List<String> key = new ArrayList<>(this.children.size());
        key.addAll(this.children.keySet().stream().map(String::valueOf).collect(Collectors.toList()));
        final String keys = String.join(", ", key.toArray(new String[0]));

        return "[" + "children: {" + keys + "}" +  ", Is complete: " + isCompleteWord + "]";
    }
}
