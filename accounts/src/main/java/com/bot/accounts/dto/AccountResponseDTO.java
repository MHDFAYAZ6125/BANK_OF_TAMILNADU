package com.bot.accounts.dto;

import com.bot.accounts.enums.SchemeType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
public class AccountResponseDTO {
    private BigDecimal balance;
    private Long customerId;
    private Long accountNumber;
    private SchemeType schemeType;
}
