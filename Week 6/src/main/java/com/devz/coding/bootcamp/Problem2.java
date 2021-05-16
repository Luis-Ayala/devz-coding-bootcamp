package com.devz.coding.bootcamp;

import java.util.Map;

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
}
