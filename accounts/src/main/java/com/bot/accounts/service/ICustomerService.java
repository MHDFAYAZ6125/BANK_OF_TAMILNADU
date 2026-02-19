package com.bot.accounts.service;

import com.bot.accounts.dto.CustomerRequestDTO;

public interface ICustomerService {

    public boolean createCustomer(CustomerRequestDTO customerRequestDTO);
    public CustomerRequestDTO findCustomerById(Long customerId);
}
