package com.devz.coding.bootcamp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void getValidBankingWindows() {
        final int n = 3;
        final int k = 4;
        final int i = 5;

        List<String> test1 = Problem1.getValidBankingWindows(n);
        assertArrayEquals(new String[]{"000", "001", "010", "100", "101"}, test1.toArray());

        List<String> test2 = Problem1.getValidBankingWindows(k);
        assertArrayEquals(new String[]{"0000", "0001", "0010", "0100", "0101", "1000", "1001", "1010"}, test2.toArray());

        List<String> test3 = Problem1.getValidBankingWindows(i);
        assertArrayEquals(new String[]{
                "00000", "00001", "00010", "00100", "00101", "01000", "01001",
                "01010", "10000", "10001", "10010", "10100", "10101"
        }, test3.toArray());
    }
}
