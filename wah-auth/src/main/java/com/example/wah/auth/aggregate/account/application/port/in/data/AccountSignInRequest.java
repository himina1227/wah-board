package com.example.wah.auth.aggregate.account.application.port.in.data;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountSignInRequest {
    private String email;

    private String password;
}
