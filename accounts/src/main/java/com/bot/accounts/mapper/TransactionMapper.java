package com.bot.accounts.mapper;

import com.bot.accounts.dto.TransactionRequestDTO;
import com.bot.accounts.entity.Transaction;
import com.bot.accounts.enums.TranTypes;

import java.time.LocalDateTime;

public class TransactionMapper {

    public static Transaction toDebitTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setAcct_num(transactionRequestDTO.getDr_account_id());
        transaction.setTranAmount(transactionRequestDTO.getAmount());
        transaction.setTranDate(LocalDateTime.now());
        transaction.setTranType(TranTypes.DEBIT.getCode());
        return transaction;
    }
    public static Transaction toCreditTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setAcct_num(transactionRequestDTO.getCr_account_id());
        transaction.setTranAmount(transactionRequestDTO.getAmount());
        transaction.setTranDate(LocalDateTime.now());
        transaction.setTranType(TranTypes.CREDIT.getCode());
        return transaction;
    }
}
