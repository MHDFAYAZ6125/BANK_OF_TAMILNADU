package com.bot.accounts.entity;

import com.bot.accounts.enums.Role;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Id
    private String user_id;
    @Enumerated(EnumType.STRING)
    private Role role;

}
