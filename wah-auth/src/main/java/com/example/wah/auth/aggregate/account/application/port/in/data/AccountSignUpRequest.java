package com.example.wah.auth.aggregate.account.application.port.in.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountSignUpRequest {

    private String name;

    private String email;

    private String password;
}
