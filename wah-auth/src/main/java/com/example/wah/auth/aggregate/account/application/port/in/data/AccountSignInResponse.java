package com.example.wah.auth.aggregate.account.application.port.in.data;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AccountSignInResponse {
    private String accessToken;

    private AccountSignInResponse.AccessToken data;

    public static AccountSignInResponse of (String accessTokenStr) {
        AccountSignInResponse.AccessToken accessToken = AccountSignInResponse.AccessToken.builder().access_token(accessTokenStr).build();

        return AccountSignInResponse.builder()
                .data(accessToken)
                .build();
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class AccessToken {

        String access_token;
    }
}
