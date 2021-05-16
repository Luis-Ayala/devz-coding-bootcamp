package com.devz.coding.bootcamp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Problem2.getMinimumCoinChange(10, coins);
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

    @Test
    void getChangeWithRandomCoins() {
        final int cost1 = 6;
        final int cost2 = 8;
        final int cost3 = 11;
        final int cost4 = 23;
        final int cost5 = 13;

        final List<Integer> change =  new ArrayList<>();
        change.add(10);
        change.add(7);
        change.add(2);
        change.add(1);

        Map<Integer, Integer> coins = new HashMap<>();
        Problem2.getChangeWithRandomCoins(cost1, coins, change);
        assertEquals(1, coins.size());
        assertTrue(coins.containsKey(2) && coins.get(2) == 3);

        coins.clear();

        Problem2.getChangeWithRandomCoins(cost2, coins, change);
        assertEquals(2, coins.size());
        assertTrue(coins.containsKey(7) && coins.get(7) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);

        coins.clear();

        Problem2.getChangeWithRandomCoins(cost3, coins, change);
        assertEquals(2, coins.size());
        assertTrue(coins.containsKey(10) && coins.get(10) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);

        coins.clear();

        Problem2.getChangeWithRandomCoins(cost4, coins, change);
        assertEquals(3, coins.size());
        assertTrue(coins.containsKey(10) && coins.get(10) == 2);
        assertTrue(coins.containsKey(2) && coins.get(2) == 1);
        assertTrue(coins.containsKey(1) && coins.get(1) == 1);

        coins.clear();

        final List<Integer> change2 =  new ArrayList<>();
        change2.add(7);
        change2.add(5);
        change2.add(2);
        final boolean isComplete = Problem2.getChangeWithRandomCoins(cost5, coins, change2);
        assertEquals(2, coins.size());
        assertTrue(coins.containsKey(7) && coins.get(7) == 1);
        assertTrue(coins.containsKey(5) && coins.get(5) == 1);
        assertFalse(isComplete);
    }
}