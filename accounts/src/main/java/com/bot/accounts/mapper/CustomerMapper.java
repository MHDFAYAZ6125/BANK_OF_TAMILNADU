package com.bot.accounts.mapper;

import com.bot.accounts.dto.CustomerRequestDTO;
import com.bot.accounts.entity.Customer;
import com.bot.accounts.enums.Genders;

import java.util.Optional;

public class CustomerMapper {

    public static CustomerRequestDTO maptoCustomerRequestDTO(Customer customer){
        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
        customerRequestDTO.setFirstName(customer.getFirstName());
        customerRequestDTO.setLastName(customer.getLastName());
        customerRequestDTO.setEmail(customer.getEmail());
        customerRequestDTO.setCity(customer.getCity());
        customerRequestDTO.setCountry(customer.getCountry());
        customerRequestDTO.setContactNumber(customer.getContactNumber());
        customerRequestDTO.setAddress(customer.getAddress());
        customerRequestDTO.setGender(Genders.fromCode(customer.getGender()));
        customerRequestDTO.setZipCode(customer.getZipCode());
        customerRequestDTO.setState(customer.getState());
        return customerRequestDTO;
    }
    public static Customer maptoCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setCity(customerRequestDTO.getCity());
        customer.setCountry(customerRequestDTO.getCountry());
        customer.setContactNumber(customerRequestDTO.getContactNumber());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setGender(customerRequestDTO.getGender().getCode());
        customer.setZipCode(customerRequestDTO.getZipCode());
        customer.setState(customerRequestDTO.getState());
        return customer;

    }
}
