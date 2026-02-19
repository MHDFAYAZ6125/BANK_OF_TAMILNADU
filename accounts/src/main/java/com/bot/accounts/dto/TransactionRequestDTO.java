package com.bot.accounts.dto;

import com.bot.accounts.enums.TranTypes;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class TransactionRequestDTO {

    @NotNull
    private Long cr_account_id;
    @NotNull
    private Long dr_account_id;
    @NotNull
    private BigDecimal amount;

}
