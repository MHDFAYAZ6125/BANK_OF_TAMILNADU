package com.bot.accounts.enums;

public enum Events {

    ADD('A'),
    VERIFY('V'),
    MODIFY('M'),
    CANCEL('C');

    private final char code;

    Events(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}
