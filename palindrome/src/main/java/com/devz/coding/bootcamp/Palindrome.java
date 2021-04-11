package com.devz.coding.bootcamp;

import static com.devz.coding.bootcamp.util.StringUtil.*;

public class Palindrome {

    public static void main(String[] args) {
        validateArgs(args);
        final boolean isPalindrome = isPalindrome(args[0]);
        System.out.println(isPalindrome);
    }

    private static void validateArgs(final String[] args) {
        if(args == null || args.length == 0)
            throw new IllegalArgumentException("Must provide a text to evaluate.");
    }
}
