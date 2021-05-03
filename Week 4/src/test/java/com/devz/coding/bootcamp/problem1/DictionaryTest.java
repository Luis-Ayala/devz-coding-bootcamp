package com.devz.coding.bootcamp.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class DictionaryTest {
    private static Dictionary dictionary = null;

    @BeforeAll
    public static void init() {
        dictionary = new Dictionary();
    }

    @Test
    void build() {
        final List<String> dictionary = Arrays.asList("java", "basic", "banco", "javier");
        DictionaryTest.dictionary.build(dictionary);
        Assertions.assertFalse(dictionary.isEmpty());
    }

    @Test
    void getNext() {
        List<String> nextCharacters = dictionary.getNext("ba");
        System.out.println(nextCharacters);
    }

    @Test
    void getAutocomplete() {
        System.out.println(dictionary.getAutocomplete("ba"));
    }
}