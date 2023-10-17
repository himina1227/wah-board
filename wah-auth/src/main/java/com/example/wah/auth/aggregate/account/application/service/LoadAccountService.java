package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.application.port.in.LoadAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class LoadAccountService implements LoadAccountUseCase {
    private final LoadAccountPort loadAccountPort;
    @Override
    public Account signInByEmail(AccountSignInRequest request) {
        return loadAccountPort.loadAccount(request);
    }
}
