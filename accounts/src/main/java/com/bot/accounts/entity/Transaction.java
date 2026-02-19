package com.bot.accounts.entity;

import com.bot.accounts.enums.TranTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="DTD")
@Getter
@Setter
public class Transaction extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "tran_id", nullable = false, updatable = false)
    private UUID tranId;

    @NotNull
    @Column(name = "tran_date")
    private LocalDateTime tranDate;
    @NotNull
    @Column(name = "acct_num",nullable = false)
    private Long acct_num;
    @NotNull
    @Column(name = "tran_type")
    private char tranType;
    @Column(name = "tran_amt")
    private BigDecimal tranAmount;
}
