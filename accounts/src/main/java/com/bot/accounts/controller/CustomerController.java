package com.bot.accounts.controller;

import com.bot.accounts.dto.CustomerRequestDTO;
import com.bot.accounts.dto.ResponseDTO;
import com.bot.accounts.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class CustomerController {
    private ICustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<ResponseDTO> createCustomer(@Valid @RequestBody CustomerRequestDTO  customerRequestDTO)
    {
        boolean isCustomerCreated = customerService.createCustomer(customerRequestDTO);

        ResponseDTO responseDTO = new ResponseDTO();
        if(isCustomerCreated) {
            responseDTO.setStatusCode("201");
            responseDTO.setStatusMsg("Customer Created");
        }else{
            responseDTO.setStatusCode("400");
            responseDTO.setStatusMsg("Customer Not Created");
        }

        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<CustomerRequestDTO> getCustomer(@RequestParam("customerId") int customerId)
    {
        Long customer_Id = (long) customerId;
        CustomerRequestDTO customerRequestDTO = customerService.findCustomerById(customer_Id);
        return ResponseEntity.ok().body(customerRequestDTO);

    }

}
