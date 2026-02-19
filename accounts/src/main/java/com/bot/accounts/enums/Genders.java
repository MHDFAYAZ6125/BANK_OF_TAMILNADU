package com.bot.accounts.enums;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public enum Genders {
    MALE('M'),
    FEMALE('F'),
    OTHER('O');
    private final char code;

    Genders(char code) {
        this.code = code;
    }

    public static Genders fromCode(char code) {
        for (Genders genders : Genders.values()) {
            if (genders.code == code) {
                return genders;
            }
        }
        throw new IllegalArgumentException("Illegal gender code " + code);
    }

}
