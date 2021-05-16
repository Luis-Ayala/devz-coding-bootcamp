package com.devz.coding.bootcamp;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void getMinimumCoinChange() {
        final int cost1 = 6;
        final int cost2 = 8;
        final int cost3 = 11;
        final int cost4 = 23;

        Map<Integer, Integer> coins = new HashMap<>();
        Problem2.getMinimumCoinChange(cost1, coins);
        assertEquals(2, coins.size());
        assertTrue(coins.containsKey(5) && coins.get(5) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);

        coins.clear();

        Problem2.getMinimumCoinChange(cost2, coins);
        assertEquals(3, coins.size());
        assertTrue(coins.containsKey(5) && coins.get(5) == 1);
        assertTrue(coins.containsKey(2) && coins.get(2) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);

        coins.clear();

        Problem2.getMinimumCoinChange(cost3, coins);
        assertEquals(2, coins.size());
        assertTrue(coins.containsKey(10) && coins.get(10) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);

        coins.clear();

        Problem2.getMinimumCoinChange(cost4, coins);
        assertEquals(3, coins.size());
        assertTrue(coins.containsKey(10) && coins.get(10) == 2);
        assertTrue(coins.containsKey(2) && coins.get(2) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);
    }
}