package com.example.wah.auth.aggregate.account.application.port.in;

import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInResponse;

public interface AccountSignInUseCase {

    AccountSignInResponse signInByEmail(AccountSignInRequest request);
}
