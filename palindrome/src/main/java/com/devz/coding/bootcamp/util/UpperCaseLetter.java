package com.devz.coding.bootcamp.util;

public enum UpperCaseLetter {
    CAPITAL_LETTER_A('A'),
    CAPITAL_LETTER_B('B'),
    CAPITAL_LETTER_C('C'),
    CAPITAL_LETTER_D('D'),
    CAPITAL_LETTER_E('E'),
    CAPITAL_LETTER_F('F'),
    CAPITAL_LETTER_G('G'),
    CAPITAL_LETTER_H('H'),
    CAPITAL_LETTER_I('I'),
    CAPITAL_LETTER_J('J'),
    CAPITAL_LETTER_K('K'),
    CAPITAL_LETTER_L('L'),
    CAPITAL_LETTER_M('M'),
    CAPITAL_LETTER_N('N'),
    CAPITAL_LETTER_O('O'),
    CAPITAL_LETTER_P('P'),
    CAPITAL_LETTER_Q('Q'),
    CAPITAL_LETTER_R('R'),
    CAPITAL_LETTER_S('S'),
    CAPITAL_LETTER_T('T'),
    CAPITAL_LETTER_U('U'),
    CAPITAL_LETTER_V('V'),
    CAPITAL_LETTER_W('W'),
    CAPITAL_LETTER_X('X'),
    CAPITAL_LETTER_Y('Y'),
    CAPITAL_LETTER_Z('Z');

    private final char letter;

    UpperCaseLetter(final char letter) {
        this.letter = letter;
    }

    public char getCapitalLetter() {
        return this.letter;
    }
}
