package com.bot.accounts.enums;

import lombok.Getter;

@Getter
public enum TranTypes {
    DEBIT('D'),
    CREDIT('C');
    private final char code;

    TranTypes(char code) {
        this.code = code;
    }

    public static TranTypes fromCode(char code) {
        for (TranTypes tranTypes : TranTypes.values()) {
            if (tranTypes.code == code) {
                return tranTypes;
            }
        }
        throw new IllegalArgumentException("Illegal gender code " + code);
    }
}
