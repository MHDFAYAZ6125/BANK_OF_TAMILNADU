package com.bot.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BaseEntity {
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private String createdAt;
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @NotNull
    @Column(name = "entity_cre_flg")
    private char entityCreationflag;
    @NotNull
    @Column(name = "del_flg")
    private char entityDeletionflag;

}
