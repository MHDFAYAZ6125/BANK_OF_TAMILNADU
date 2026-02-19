package com.bot.accounts.controller;

import com.bot.accounts.dto.AccountResponseDTO;
import com.bot.accounts.dto.CreateAccountsRequestDTO;
import com.bot.accounts.dto.ResponseDTO;
import com.bot.accounts.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class AccountsController {

    IAccountService accountsService;
    public AccountsController(IAccountService accountsService) {
        this.accountsService = accountsService;
    }


    @PostMapping("/createaccount")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CreateAccountsRequestDTO createAccountsRequestDTO) {

        boolean isAccountCreated = accountsService.createAccount(createAccountsRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO();
        if(isAccountCreated) {
            responseDTO.setStatusCode("201");
            responseDTO.setStatusMsg("Customer Created");
        }else{
            responseDTO.setStatusCode("400");
            responseDTO.setStatusMsg("Customer Not Created");
        }

        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/getAccount")
    public ResponseEntity<AccountResponseDTO> getAccount(@RequestParam("accountNumber") Long accountNumber) {
        AccountResponseDTO accountResponseDTO = accountsService.fetchAccountDetails(accountNumber);
        return ResponseEntity.ok().body(accountResponseDTO);
    }

}
