package com.game;

public enum BoardSymbol {
    X('X'), O('0'), BLANK('_');

    private final char value;

    BoardSymbol(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
