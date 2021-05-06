package com.devz.coding.bootcamp.problem1;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    private final TrieNode root;

    public Dictionary() {
        root = new TrieNode();
    }

    public void build(final List<String> words) {
        for(String word : words)
            insert(word);
    }

    public List<String> getNext(final String prefix) {
        final TrieNode prefixes = getPrefixes(prefix);

        return prefixes != null ? prefixes.children.keySet().stream().map(String::valueOf).collect(Collectors.toList())
                : new ArrayList<>(0);
    }

    public List<String> getAutocomplete(final String prefix) {
        final List<String> words = new ArrayList<>();
        final TrieNode prefixes = getPrefixes(prefix);
        final Deque<Map.Entry<Character, TrieNode>> stack = new ArrayDeque<>();
        prefixes.children.entrySet().forEach(stack::push);

        while(!stack.isEmpty()) {
            Map.Entry<Character, TrieNode> node = stack.pop();
            if(node.getValue().isCompleteWord)
                words.add(node.getValue().word);

            node.getValue().children.entrySet().forEach(stack::push);
        }

        return words;
    }

    private TrieNode getPrefixes(final String prefix) {
        TrieNode current = root;
        TrieNode prefixes = null;

        final char[] wordAsChar = prefix.toCharArray();

        for (final char letter : wordAsChar) {
            prefixes = current.children.get(letter);

            if (prefixes == null)
                break;

            current = prefixes;
        }

        return prefixes;
    }

    public TrieNode getDictionary() {
        return this.root;
    }

    public boolean isEmpty() {
        return !this.root.children.size() > 0;
    }

    private void insert(String word) {
        TrieNode current = root;
        final char[] wordAsChar = word.toCharArray();

        for (char c : wordAsChar) {
            current = current.children.computeIfAbsent(c, compute -> new TrieNode());
        }
        current.isCompleteWord = true;
        current.word = word;
    }
}
