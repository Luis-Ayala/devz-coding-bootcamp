package com.devz.coding.bootcamp;

import static com.devz.coding.bootcamp.util.StringUtil.*;

public class Palindrome {

    /**
     * Entry point
     * @param args a List of arguments.
     */
    public static void main(String[] args) {
        validateArgs(args);
        final boolean isPalindrome = isPalindrome(args[0]);
        System.out.println(isPalindrome);
    }

    /**
     * Validate the arguments, have to be a least one argument.
     * @param args a List of arguments.
     */
    private static void validateArgs(final String[] args) {
        if(args == null || args.length == 0)
            throw new IllegalArgumentException("Must provide a text to evaluate.");
    }
}
