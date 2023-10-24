package com.example.wah.auth.aggregate.account.adapter.out.persistence;

import com.example.wah.common.PersistenceAdapter;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.repository.AccountRepository;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class LoadAccountPersistenceAdapter implements LoadAccountPort {

    private final AccountRepository repository;
    @Override
    public Account loadAccount(String email) {
        return repository.findByEmail(email);
    }
}
