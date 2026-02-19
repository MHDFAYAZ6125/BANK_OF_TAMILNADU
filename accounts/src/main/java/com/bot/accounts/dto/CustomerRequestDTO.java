package com.bot.accounts.dto;

import com.bot.accounts.enums.Events;
import com.bot.accounts.enums.Genders;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class CustomerRequestDTO {
    @NotNull
    @Size(min = 1, max = 15, message = "First Name should be size between 1-15")
    private String firstName;
    @NotNull
    @Size(min = 1, max = 10, message = "Last Name should be size between 1-15")
    private String lastName;
    @NotNull
    @Email
    private String email;

    @NotNull
    private Events event;
    @NotNull
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid mobile number format")
    private String contactNumber;
    @NotNull
    @Size(min = 5, message = "At least 5 character is required")
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String country;
    @NotNull
    private String zipCode;
    @NotNull
    private Genders gender;
}
