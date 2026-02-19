package com.bot.accounts.service;

import com.bot.accounts.dto.AccountResponseDTO;
import com.bot.accounts.dto.CreateAccountsRequestDTO;

public interface IAccountService {

    public boolean createAccount(CreateAccountsRequestDTO createAccountsRequestDTO);
    public AccountResponseDTO fetchAccountDetails(Long AccountNumber);
   // public AccountResponseDTO updateAccount(AccountResponseDTO accountResponseDTO);
}
