package com.example.wah.auth.aggregate.account.adapter.out.persistence;


import com.example.wah.common.PersistenceAdapter;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.repository.AccountRepository;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAccountPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SaveAccountPersistenceAdapter implements SaveAccountPort {

    private final AccountRepository repository;

    @Override
    public void save(Account account) {
        repository.save(account);
    }
}
