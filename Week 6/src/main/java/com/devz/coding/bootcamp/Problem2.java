package com.devz.coding.bootcamp;

import java.util.*;

public class Problem2 {

    public static void getMinimumCoinChange(int cost, final Map<Integer, Integer> results) {
        int quotient = 0;
        int remainder = 0;
        int coin = 0;

        if(cost >= 10) {
            quotient = cost / 10;
            remainder = cost % 10;
            coin = 10;
        } else if(cost >= 5) {
            quotient = cost / 5;
            remainder = cost % 5;
            coin = 5;
        } else if(cost >= 2) {
            quotient = cost / 2;
            remainder = cost % 2;
            coin = 2;
        } else if(cost == 1) {
            quotient = cost;
            remainder = 0;
            coin = 1;
        }

        results.put(coin, quotient);
        cost = remainder;

        if(cost == 0)
            return;

        getMinimumCoinChange(cost, results);
    }

    public static boolean getChangeWithRandomCoins(int cost, final Map<Integer, Integer> results, final List<Integer> coins) {
        coins.sort(Collections.reverseOrder());
        for (int coin = 0; coin < coins.size() && cost != 0; coin++) {
            final int maxCoin = coins.get(coin);
            if (cost >= maxCoin) {
                results.put(maxCoin, cost / maxCoin);
                cost = cost % maxCoin;
            }
        }

        return cost == 0;
    }
}
