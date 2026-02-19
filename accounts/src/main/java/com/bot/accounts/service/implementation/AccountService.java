package com.bot.accounts.service.implementation;

import com.bot.accounts.dto.AccountResponseDTO;
import com.bot.accounts.dto.CreateAccountsRequestDTO;
import com.bot.accounts.entity.Accounts;
import com.bot.accounts.exception.CustomerAlreadyExistException;
import com.bot.accounts.exception.ResourceNotFoundException;
import com.bot.accounts.mapper.AccountMapper;
import com.bot.accounts.repository.AccountsRepository;
import com.bot.accounts.repository.CustomerRepository;
import com.bot.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class AccountService implements IAccountService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;
    public AccountService( AccountsRepository accountsRepository, CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean createAccount(CreateAccountsRequestDTO createAccountsRequestDTO){
        Accounts accounts = AccountMapper.mapRequestDTOToAccounts(createAccountsRequestDTO);
        if(!customerRepository.findByCustomerId(createAccountsRequestDTO.getCustomerId()).isPresent()){
            throw new CustomerAlreadyExistException("Customer not exist with the given Customer Id"
                    +createAccountsRequestDTO.getCustomerId());
        }
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        accounts.setAccountNumber(randomAccNumber);
        accounts.setAccountBalance(createAccountsRequestDTO.getDepositAmount());
        accounts.setAvailableBalance(createAccountsRequestDTO.getDepositAmount());
        accounts.setBankId("BOT01");
        accounts.setAccountStatus("ACTIVE");
        accounts.setBranchId("B01");
        accounts.setCreatedBy("STAFF01");
        if(createAccountsRequestDTO.getEvent().getCode()!='V')
        {
            accounts.setEntityCreationflag('N');
            accounts.setEntityDeletionflag('N');
        }
        accountsRepository.save(accounts);

        return true;
    }

    @Override
    public AccountResponseDTO fetchAccountDetails(Long accountNumber){
        Accounts accounts = accountsRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Given Account number is not present: " + accountNumber));
        return AccountMapper.mapToAccountResponseDTO(accounts);
    }





}
