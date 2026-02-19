package com.bot.accounts.dto;

import com.bot.accounts.enums.Events;
import com.bot.accounts.enums.SchemeType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class CreateAccountsRequestDTO {
    @NotNull
    @Size(min = 1, max = 20)
    private String accountName;
    @NotNull
    private SchemeType schemeType;
    @NotNull
    private Long customerId;
    @NotNull
    @Positive
    private BigDecimal depositAmount;
    @NotNull
    private Events event;

}
