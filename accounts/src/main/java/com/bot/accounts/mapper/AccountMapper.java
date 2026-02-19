package com.bot.accounts.mapper;

import com.bot.accounts.dto.AccountResponseDTO;
import com.bot.accounts.dto.CreateAccountsRequestDTO;
import com.bot.accounts.entity.Accounts;

public class AccountMapper {

    public static CreateAccountsRequestDTO mapToAccountRequestDTO(Accounts accounts) {
        CreateAccountsRequestDTO accountsDTO = new CreateAccountsRequestDTO();
        accountsDTO.setAccountName(accounts.getAccountName());
        accountsDTO.setCustomerId(accounts.getCustomerId());
        accountsDTO.setSchemeType(accounts.getSchemeType());
        return accountsDTO;
    }

    public static Accounts mapRequestDTOToAccounts(CreateAccountsRequestDTO createAccountsRequestDTO) {
        Accounts accounts = new Accounts();
        accounts.setAccountName(createAccountsRequestDTO.getAccountName());
        accounts.setCustomerId(createAccountsRequestDTO.getCustomerId());
        accounts.setSchemeType(createAccountsRequestDTO.getSchemeType());
        return accounts;
    }

    public static AccountResponseDTO mapToAccountResponseDTO(Accounts accounts) {
        AccountResponseDTO accountsDTO = new AccountResponseDTO();
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setCustomerId(accounts.getCustomerId());
        accountsDTO.setSchemeType(accounts.getSchemeType());
        accountsDTO.setBalance(accounts.getAvailableBalance());
        return accountsDTO;
    }
}

