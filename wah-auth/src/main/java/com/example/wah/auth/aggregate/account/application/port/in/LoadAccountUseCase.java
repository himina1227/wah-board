package com.example.wah.auth.aggregate.account.application.port.in;

import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInResponse;

public interface LoadAccountUseCase {

    AccountSignInResponse signInByEmail(AccountSignInRequest request);
}
