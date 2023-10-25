package com.example.wah.auth.aggregate.account.adapter.out.persistence;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.repository.AuthCodeRepository;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAuthCodePort;
import com.example.wah.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SaveAuthCodePersistenceAdapter implements SaveAuthCodePort {
    private final AuthCodeRepository repository;

    @Override
    public void save(AuthCode authCode) {
        repository.save(authCode);
    }
}
