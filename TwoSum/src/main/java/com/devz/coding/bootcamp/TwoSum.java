package com.devz.coding.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, -1, 1, 5 };
        System.out.println(Arrays.toString(twoSum(nums, 0)));
    }

    public static int[] twoSum(final int[] nums, final int target) {
        final List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for(int index = 0; index < nums.length; index++) {
            int found = Collections.binarySearch(numbers, (target - numbers.get(index)));
            if( found == -1 || found == index)
                continue;

            return new int[] { index, found };

        }

        return new int[0];
    }
}
