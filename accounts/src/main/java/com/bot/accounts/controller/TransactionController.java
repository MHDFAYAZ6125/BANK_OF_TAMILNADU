package com.bot.accounts.controller;

import com.bot.accounts.dto.ResponseDTO;
import com.bot.accounts.dto.TransactionRequestDTO;
import com.bot.accounts.exception.InsufficientFund;
import com.bot.accounts.service.implementation.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<ResponseDTO> transferTransaction(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            transactionService.transfer(transactionRequestDTO);
            responseDTO.setStatusMsg("Transaction transfer success.");
            responseDTO.setStatusCode("200");
        }catch (InsufficientFund e){
            responseDTO.setStatusMsg("Insufficient Fund.");
            responseDTO.setStatusCode("400");
            throw new InsufficientFund("Insufficient Fund");
        }
        return ResponseEntity.ok().body(responseDTO);
    }
}
