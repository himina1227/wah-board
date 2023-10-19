package com.example.wah.auth.aggregate.account.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Authority {
    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}
