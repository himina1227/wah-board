package com.example.wah.auth.aggregate.account.adapter.out.persistence;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.repository.AuthCodeRepository;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAuthCodePort;
import com.example.wah.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class LoadAuthCodePersistenceAdapter implements LoadAuthCodePort {

    private final AuthCodeRepository authCodeRepository;
    @Override
    public Optional<AuthCode> loadAuthCode(String email, String code) {
        return authCodeRepository.findByEmailAndCode(email, code);
    }
}
