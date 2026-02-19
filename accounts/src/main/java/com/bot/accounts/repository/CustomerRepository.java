package com.bot.accounts.repository;

import com.bot.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByContactNumber(String contactNumber);

    Optional<Customer> findByCustomerId(Long customerId);

}
