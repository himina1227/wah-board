package com.example.wah.auth.aggregate.account.adapter.out.persistence.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Account {
    @Schema(description = "아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "이름", nullable = false, example = "김이름")
    @Setter
    private String name;

    @Schema(description = "이메일", nullable = false, example = "abc@naver.com")
    @Setter
    private String email;

    @Schema(description = "패스워드", nullable = false)
    @Setter
    private String password;

    @Builder.Default
    @Schema(description = "랭킹")
    private int rangKing = 0;

}
