package com.devz.coding.bootcamp.util;

public class StringUtil {

    private static final char EMPTY_CHAR = ' ';

    public static boolean isPalindrome(final String text) {
        boolean mismatch = false;

        final char[] normalizedText = normalizeText(text);
        final char[] reversedText = reverseText(normalizedText);

        for(int index = 0; index < normalizedText.length; index++) {
            if(normalizedText[index] != reversedText[index]) {
                mismatch = true;
                break;
            }
        }

        return !mismatch;
    }

    private static char[] normalizeText(final String text) {
        final char[] charArray = text.toCharArray();
        final char[] lowerCaseArray = toLowerCase(charArray);
        final char[] removedSpaceArray = removeSpaces(lowerCaseArray);

        return stripAccents(removedSpaceArray);
    }

    private static char[] reverseText(final char[] textToReverse) {
        final char[] newText = new char[textToReverse.length];

        for(int index = (textToReverse.length - 1), newIndex = 0; index >= 0; index--, newIndex++) {
            newText[newIndex] = textToReverse[index];
        }

        return newText;
    }

    private static char[] removeSpaces(final char[] text) {
        final char[] newText = new char[text.length];

        for(int index = 0, newIndex = 0; index < text.length; index++) {
            final char character = text[index];

            if(! (character == EMPTY_CHAR)) {
                newText[newIndex] = character;
                newIndex++;
            }
        }

        return trimArray(newText);
    }

    private static char[] toLowerCase(final char[] text) {
        final char[] lowerCase = new char[text.length];
        for(int index = 0; index < text.length; index++) {
            if(isUpperCase(text[index])) {
                lowerCase[index] = (char) (text[index] + 32);
            } else {
                lowerCase[index] = text[index];
            }
        }

        return lowerCase;
    }

    private static char[] stripAccents(final char[] text) {
        final char[] newText = new char[text.length];
        for(int index = 0; index < text.length; index++) {
            if(isAccent(text[index])) {
                newText[index] = LettersWithOutAcute.convertLetter(text[index]);
            } else {
                newText[index] = text[index];
            }
        }

        return newText;
    }

    private static boolean isAccent(final char letter) {
        boolean isAccent = false;

        for(int index = 0; index < LettersWithAcute.values().length; index++) {
            if(letter == LettersWithAcute.values()[index].getLetterWithAcute()) {
                isAccent = true;
                break;
            }
        }

        return isAccent;
    }

    private static boolean isUpperCase(final char letter) {
        boolean isUpperCase = false;

        for (UpperCaseLetter upperCaseLetter : UpperCaseLetter.values()) {
            if (letter == upperCaseLetter.getCapitalLetter()) {
                isUpperCase = true;
                break;
            }
        }

        return isUpperCase;
    }

    private static char[] trimArray(final char[] text) {
        int numberOfSpaces = 0;
        for (final char character : text) {
            if (character == EMPTY_CHAR || character == '\u0000') {
                numberOfSpaces++;
            }
        }

        final char[] newArray = new char[text.length - numberOfSpaces];
        System.arraycopy(text, 0, newArray, 0, newArray.length);

        return newArray;
    }
}
