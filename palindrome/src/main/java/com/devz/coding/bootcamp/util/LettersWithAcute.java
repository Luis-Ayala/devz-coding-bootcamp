package com.devz.coding.bootcamp.util;

public enum LettersWithAcute {

    SMALL_LETTER_A_WITH_ACUTE ('á'),
    SMALL_LETTER_E_WITH_ACUTE ('é'),
    SMALL_LETTER_I_WITH_ACUTE ('í'),
    SMALL_LETTER_O_WITH_ACUTE ('ó'),
    SMALL_LETTER_U_WITH_ACUTE ('ú'),
    CAPITAL_LETTER_A_WITH_ACUTE ('Á'),
    CAPITAL_LETTER_E_WITH_ACUTE ('É'),
    CAPITAL_LETTER_I_WITH_ACUTE ('Í'),
    CAPITAL_LETTER_O_WITH_ACUTE ('Ó'),
    CAPITAL_LETTER_U_WITH_ACUTE ('Ú');

    private final char letter;

    LettersWithAcute(final char letter) {
        this.letter = letter;
    }

    public char getLetterWithAcute() {
        return this.letter;
    }

    public static LettersWithAcute fromChar(char text) {
        for (int index= 0; index < LettersWithAcute.values().length; index++) {
            if (text == LettersWithAcute.values()[index].letter) {
                return LettersWithAcute.values()[index];
            }
        }

        throw new IllegalArgumentException("No letter with acute " + text + " found");
    }
}
