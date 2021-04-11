package com.devz.coding.bootcamp.util;

import com.devz.coding.bootcamp.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    public void isPalindrome() {
        final String text = "La ruta nos aportó otro paso natural";

        final boolean isPalindrome = StringUtil.isPalindrome(text);

        Assertions.assertTrue(isPalindrome);
    }

    @Test
    public void isNotPalindrome() {
        final String text = "Claramente, esto no es un palíndromo";

        final boolean isPalindrome = StringUtil.isPalindrome(text);

        Assertions.assertFalse(isPalindrome);
    }
}