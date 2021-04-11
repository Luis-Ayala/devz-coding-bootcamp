package com.devz.coding.bootcamp.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    @Test
    public void isPalindrome() {
        final String spanishPalindrome1 = "La ruta nos aportó otro paso natural";
        final String spanishPalindrome2 = "Roma ni se conoce sin oro, ni se conoce sin amor.";
        final String spanishPalindrome3 = "Allí por la tropa portado, traído a ese paraje de maniobras, una tipa como capitán usar boina me dejara, pese a odiar toda tropa por tal ropilla."; // (de Luis Torrent)
        final String spanishPalindrome4 = "A mamá, Roma le aviva el amor a papá, y a papá, Roma le aviva el amor a mamá.";

        final String englishPalindrome1 = "Madam, in Eden I'm Adam";
        final String germanPalindrome1 = "Ein Neger mit Gazelle zagt im Regen nie.";

        final boolean isSpanishPalindrome1 = StringUtil.isPalindrome(spanishPalindrome1);
        final boolean isSpanishPalindrome2 = StringUtil.isPalindrome(spanishPalindrome2);
        final boolean isSpanishPalindrome3 = StringUtil.isPalindrome(spanishPalindrome3);
        final boolean isSpanishPalindrome4 = StringUtil.isPalindrome(spanishPalindrome4);
        final boolean isEnglishPalindrome1 = StringUtil.isPalindrome(englishPalindrome1);
        final boolean isGermanPalindrome1 = StringUtil.isPalindrome(germanPalindrome1);

        Assertions.assertTrue(isSpanishPalindrome1);
        Assertions.assertTrue(isSpanishPalindrome2);
        Assertions.assertTrue(isSpanishPalindrome3);
        Assertions.assertTrue(isSpanishPalindrome4);
        Assertions.assertTrue(isEnglishPalindrome1);
        Assertions.assertTrue(isGermanPalindrome1);
    }

    @Test
    public void isNotPalindrome() {
        final String text = "Claramente, esto no es un palíndromo";

        final boolean isPalindrome = StringUtil.isPalindrome(text);

        Assertions.assertFalse(isPalindrome);
    }
}
