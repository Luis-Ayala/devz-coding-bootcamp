package com.devz.coding.bootcamp.problem1;

import java.util.Arrays;

public class Testito {

    public static void main(String... a) {
        int[] aa = { 12, 11, 13, 5, 6, 7 };
        int[] sorted = HeapMinSort.sort(aa);

        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(HeapMinSort.getFirstValues(4)));

    }
}
