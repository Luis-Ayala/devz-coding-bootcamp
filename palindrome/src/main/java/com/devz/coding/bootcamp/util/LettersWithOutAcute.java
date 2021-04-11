package com.devz.coding.bootcamp.util;

public enum LettersWithOutAcute {

    SMALL_LETTER_A_WITHOUT_ACUTE ('a'),
    SMALL_LETTER_E_WITHOUT_ACUTE ('e'),
    SMALL_LETTER_I_WITHOUT_ACUTE ('i'),
    SMALL_LETTER_O_WITHOUT_ACUTE ('o'),
    SMALL_LETTER_U_WITHOUT_ACUTE ('u'),
    CAPITAL_LETTER_A_WITHOUT_ACUTE ('A'),
    CAPITAL_LETTER_E_WITHOUT_ACUTE ('E'),
    CAPITAL_LETTER_I_WITHOUT_ACUTE ('I'),
    CAPITAL_LETTER_O_WITHOUT_ACUTE ('O'),
    CAPITAL_LETTER_U_WITHOUT_ACUTE ('U');

    private final char letter;

    LettersWithOutAcute(final char letter) {
        this.letter = letter;
    }

    public char getLetterWithOutAcute() {
        return this.letter;
    }

    public static char convertLetter(final char letter) {
        char equivalentLetter = 0;
        for(int index = 0; index < LettersWithOutAcute.values().length; index++) {
            switch (LettersWithAcute.fromChar(letter)) {
                case SMALL_LETTER_A_WITH_ACUTE:
                    equivalentLetter = SMALL_LETTER_A_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case SMALL_LETTER_E_WITH_ACUTE:
                    equivalentLetter = SMALL_LETTER_E_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case SMALL_LETTER_I_WITH_ACUTE:
                    equivalentLetter = SMALL_LETTER_I_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case SMALL_LETTER_O_WITH_ACUTE:
                    equivalentLetter = SMALL_LETTER_O_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case SMALL_LETTER_U_WITH_ACUTE:
                    equivalentLetter = SMALL_LETTER_U_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case CAPITAL_LETTER_A_WITH_ACUTE:
                    equivalentLetter = CAPITAL_LETTER_A_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case CAPITAL_LETTER_E_WITH_ACUTE:
                    equivalentLetter = CAPITAL_LETTER_E_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case CAPITAL_LETTER_I_WITH_ACUTE:
                    equivalentLetter = CAPITAL_LETTER_I_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case CAPITAL_LETTER_O_WITH_ACUTE:
                    equivalentLetter = CAPITAL_LETTER_O_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;

                case CAPITAL_LETTER_U_WITH_ACUTE:
                    equivalentLetter = CAPITAL_LETTER_U_WITHOUT_ACUTE.getLetterWithOutAcute();
                    break;
            }
        }

        if(equivalentLetter == 0)
            throw new IllegalArgumentException("No equivalent letter without acute " + letter + " found");

        return equivalentLetter;
    }
}
