package com.example.wah.auth.aggregate.account.application.port.in;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;

public interface LoadAccountUseCase {

    Account signInByEmail(AccountSignInRequest request);
}
