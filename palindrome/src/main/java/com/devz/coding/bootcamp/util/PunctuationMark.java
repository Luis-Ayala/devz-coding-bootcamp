package com.devz.coding.bootcamp.util;

public enum PunctuationMark {
    EXCLAMATION_MARK('!'),
    QUOTATION_MARK('"'),
    APOSTROPHE('\''),
    QUESTION_MARK('?'),
    COMMA(','),
    SEMICOLON(';'),
    FULL_STOP('.');

    private final char mark;

    PunctuationMark(final char mark) {
        this.mark = mark;
    }

    public char getPunctuationMark() {
        return this.mark;
    }
}
