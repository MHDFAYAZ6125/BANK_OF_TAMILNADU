package com.bot.accounts.service.implementation;

import com.bot.accounts.dto.TransactionRequestDTO;
import com.bot.accounts.entity.Accounts;
import com.bot.accounts.entity.Transaction;
import com.bot.accounts.exception.InsufficientFund;
import com.bot.accounts.exception.ResourceNotFoundException;
import com.bot.accounts.mapper.TransactionMapper;
import com.bot.accounts.repository.AccountsRepository;
import com.bot.accounts.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountsRepository accountsRepository;
    public TransactionService(TransactionRepository transactionRepository, AccountsRepository accountsRepository) {
        this.transactionRepository = transactionRepository;
        this.accountsRepository = accountsRepository;
    }

    @Transactional
    public void transfer(TransactionRequestDTO transactionRequestDTO) {

        Accounts debitAccount = accountsRepository.findByAccountNumber(transactionRequestDTO.getDr_account_id())
                .orElseThrow(() -> new ResourceNotFoundException("Given Account number is not present: " + transactionRequestDTO.getDr_account_id()));

        Accounts creditAccount = accountsRepository.findByAccountNumber(transactionRequestDTO.getCr_account_id())
                .orElseThrow(() -> new ResourceNotFoundException("Given Account number is not present: " + transactionRequestDTO.getCr_account_id()));

        if(debitAccount.getAvailableBalance().compareTo(transactionRequestDTO.getAmount())<0)
        {
            throw new InsufficientFund("Insufficient Fund");
        }

        debitAccount.setAvailableBalance(
                debitAccount.getAvailableBalance().subtract(transactionRequestDTO.getAmount()));
        creditAccount.setAvailableBalance(
                creditAccount.getAvailableBalance().add(transactionRequestDTO.getAmount()));

        Transaction DR_transaction = TransactionMapper.toDebitTransaction(transactionRequestDTO);
        Transaction CR_transaction = TransactionMapper.toCreditTransaction(transactionRequestDTO);

        transactionRepository.save(DR_transaction);
        transactionRepository.save(CR_transaction);
       // accountsRepository.save(debitAccount);
      //  accountsRepository.save(creditAccount);

    }
}
