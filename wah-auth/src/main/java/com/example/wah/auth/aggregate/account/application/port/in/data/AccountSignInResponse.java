package com.example.wah.auth.aggregate.account.application.port.in.data;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountSignInResponse {
    private String accessToken;

    public static AccountSignInResponse of (String accessTokenStr) {
        return AccountSignInResponse.builder()
                .accessToken(accessTokenStr)
                .build();
    }

}
