package com.bot.accounts.exception;

public class InsufficientFund extends RuntimeException {
    public InsufficientFund(String message) {
        super(message);
    }
}
