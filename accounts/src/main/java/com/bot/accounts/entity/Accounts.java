package com.bot.accounts.entity;

import com.bot.accounts.enums.SchemeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
public class Accounts extends BaseEntity {

    @Id
    @Column(unique = true, nullable = false, name = "acct_num")
    private Long accountNumber;
    @NotNull
    @Column(name = "acct_name")
    private String accountName;
    @NotNull
    @Column(name = "schm_type")
    @Enumerated(EnumType.STRING)
    private SchemeType schemeType;
    @NotNull
    @Column(name = "status")
    private String accountStatus;
    @NotNull
    @Column(name = "avali_bal")
    private BigDecimal availableBalance;
    @NotNull
    @Column(name = "Tot_bal")
    private BigDecimal accountBalance;
    @NotNull
    @Column(name = "cust_id")
    private Long customerId;
    @NotNull
    @Column(name = "sol_id")
    private String branchId;
    @NotNull
    @Column(name = "bank_id")
    private String bankId;


}
