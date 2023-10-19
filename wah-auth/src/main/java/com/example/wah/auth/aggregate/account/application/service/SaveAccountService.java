package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Authority;
import com.example.wah.auth.aggregate.account.application.port.in.SaveAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
@RequiredArgsConstructor
@Service
public class SaveAccountService implements SaveAccountUseCase {

    private final SaveAccountPort saveAccountPort;
    private final PasswordEncoder passwordEncoder;
    public void signUpByEmail(AccountSignUpRequest request) {

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Account newAccount = Account.builder()
                .name(request.getName())
                .email(request.getEmail())
                .authorities(Collections.singleton(authority))
                .password(passwordEncoder.encode(request.getPassword()))
                .activated(true).build();

        saveAccountPort.save(newAccount);

    }

}
