package com.example.wah.auth.aggregate.account.application.port.in;

import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;

public interface SaveAccountUseCase {
    void signUpByEmail(AccountSignUpRequest request);
}
