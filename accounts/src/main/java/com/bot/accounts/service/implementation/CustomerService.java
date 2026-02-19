package com.bot.accounts.service.implementation;

import com.bot.accounts.dto.CustomerRequestDTO;
import com.bot.accounts.entity.Customer;
import com.bot.accounts.exception.CustomerAlreadyExistException;
import com.bot.accounts.exception.ResourceNotFoundException;
import com.bot.accounts.mapper.CustomerMapper;
import com.bot.accounts.repository.CustomerRepository;
import com.bot.accounts.service.ICustomerService;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {

    public CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = CustomerMapper.maptoCustomer(customerRequestDTO);
        if(customerRepository.findByContactNumber(customer.getContactNumber()).isPresent()){
            throw new CustomerAlreadyExistException("Customer already exist with the given Contact Number"
                    +customerRequestDTO.getContactNumber());
        }else{
            customer.setCreatedBy("STAFF01");
            customer.setGender(customerRequestDTO.getGender().getCode());
            if(customerRequestDTO.getEvent().getCode()!='V')
            {
                customer.setEntityCreationflag('N');
                customer.setEntityDeletionflag('N');
            }
            customerRepository.save(customer);
            return true;
        }
    }

    @Override
    public CustomerRequestDTO findCustomerById(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Given Customer Id is not present: " + customerId));

        return CustomerMapper.maptoCustomerRequestDTO(customer);
    }

}
