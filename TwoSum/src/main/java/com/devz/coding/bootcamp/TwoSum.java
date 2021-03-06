package com.devz.coding.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, -1, 1, 5 };
        System.out.println(Arrays.toString(twoSum(nums, 0))); //[1, 2]
    }

    public static int[] twoSum(final int[] nums, final int target) {
        Map<Integer, Integer> cached = new HashMap<>();

        for(int index = 0; index < nums.length; index++) {
            int complement = target - nums[index];

            if (cached.containsKey(complement)) {
                return new int[] { cached.get(complement) , index };
            }

            cached.put(nums[index], index);
        }

        return new int[0];
    }
}
